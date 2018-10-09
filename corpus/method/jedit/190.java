private void processExtraClassPathFileLists() throws BuildException {
    for (Iterator jarIter = mExtraClassPathFileLists.iterator(); jarIter.hasNext(); ) {
        FileList fl = (FileList) jarIter.next();
        Project p = fl.getProject();
        File srcDir = fl.getDir(p);
        String[] files = fl.getFiles(p);
        for (int i = 0; i < files.length; i++) {
            File f = new File(srcDir, files[i]);
            String path = f.getPath().replace(File.separatorChar, '/');
            bundleProperties.addToExtraClassPath(path);
        }
    }
}