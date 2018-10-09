/**
     * do the business
     * @throws BuildException on error
     */
public void execute() throws BuildException {
    if (destFile == null) {
        throw new BuildException("destFile attribute must be set!", getLocation());
    }
    if (destFile.exists() && destFile.isDirectory()) {
        throw new BuildException("destFile is a directory!", getLocation());
    }
    if (destFile.exists() && !destFile.canWrite()) {
        throw new BuildException("Can not write to the specified destFile!", getLocation());
    }
    Vector savedFileSets = (Vector) filesets.clone();
    try {
        if (baseDir != null) {
            if (!baseDir.exists()) {
                throw new BuildException("basedir does not exist!", getLocation());
            }
            // add the main fileset to the list of filesets to process.
            ArFileSet mainFileSet = new ArFileSet(fileset);
            mainFileSet.setDir(baseDir);
            filesets.addElement(mainFileSet);
        }
        if (filesets.size() == 0) {
            throw new BuildException("You must supply either a basedir " + "attribute or some nested filesets.", getLocation());
        }
        // check if ar is out of date with respect to each
        // fileset
        boolean upToDate = true;
        for (Enumeration e = filesets.elements(); e.hasMoreElements(); ) {
            ArFileSet fs = (ArFileSet) e.nextElement();
            String[] files = fs.getFiles(getProject());
            if (!archiveIsUpToDate(files, fs.getDir(getProject()))) {
                upToDate = false;
            }
            for (int i = 0; i < files.length; ++i) {
                if (destFile.equals(new File(fs.getDir(getProject()), files[i]))) {
                    throw new BuildException("An ar file cannot include " + "itself", getLocation());
                }
            }
        }
        if (upToDate) {
            log("Nothing to do: " + destFile.getAbsolutePath() + " is up to date.", Project.MSG_INFO);
            return;
        }
        log("Building ar: " + destFile.getAbsolutePath(), Project.MSG_INFO);
        ArOutputStream aOut = null;
        try {
            aOut = new ArOutputStream(new BufferedOutputStream(new FileOutputStream(destFile)));
            if (longFileMode.isTruncateMode() || longFileMode.isWarnMode()) {
                aOut.setLongFileMode(ArOutputStream.LONGFILE_TRUNCATE);
            } else if (longFileMode.isFailMode() || longFileMode.isOmitMode()) {
                aOut.setLongFileMode(ArOutputStream.LONGFILE_ERROR);
            } else if (longFileMode.isBsdMode()) {
                aOut.setLongFileMode(ArOutputStream.LONGFILE_BSD);
            } else {
                // GNU
                aOut.setLongFileMode(ArOutputStream.LONGFILE_GNU);
            }
            longWarningGiven = false;
            for (Enumeration e = filesets.elements(); e.hasMoreElements(); ) {
                ArFileSet fs = (ArFileSet) e.nextElement();
                String[] files = fs.getFiles(getProject());
                if (files.length > 1 && fs.getFullpath().length() > 0) {
                    throw new BuildException("fullpath attribute may only " + "be specified for " + "filesets that specify a " + "single file.");
                }
                for (int i = 0; i < files.length; i++) {
                    File f = new File(fs.getDir(getProject()), files[i]);
                    arFile(f, aOut, fs);
                }
            }
        } catch (IOException ioe) {
            String msg = "Problem creating AR: " + ioe.getMessage();
            throw new BuildException(msg, ioe, getLocation());
        } finally {
            FileUtils.close(aOut);
        }
    } finally {
        filesets = savedFileSets;
    }
}