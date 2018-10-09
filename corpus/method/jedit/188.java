private void processExtraClassPathFileSets() throws BuildException {
    for (Iterator jarIter = mExtraClassPathFileSets.iterator(); jarIter.hasNext(); ) {
        FileSet fs = (FileSet) jarIter.next();
        Project p = fs.getProject();
        File srcDir = fs.getDir(p);
        FileScanner ds = fs.getDirectoryScanner(p);
        fs.setupDirectoryScanner(ds, p);
        ds.scan();
        String[] files = ds.getIncludedFiles();
        for (int i = 0; i < files.length; i++) {
            File f = new File(srcDir, files[i]);
            String path = f.getPath().replace(File.separatorChar, '/');
            bundleProperties.addToExtraClassPath(path);
        }
    }
}