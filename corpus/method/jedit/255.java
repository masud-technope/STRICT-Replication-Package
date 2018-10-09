/**
         *  Get a list of files and directories specified in the fileset.
         * @param p the current project.
         * @return a list of file and directory names, relative to
         *    the baseDir for the project.
         */
public String[] getFiles(Project p) {
    if (files == null) {
        DirectoryScanner ds = getDirectoryScanner(p);
        files = ds.getIncludedFiles();
    }
    return files;
}