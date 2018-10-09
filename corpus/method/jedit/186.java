private void processExtraClassPathAttrs() throws BuildException {
    for (Iterator jarIter = mExtraClassPathAttrs.iterator(); jarIter.hasNext(); ) {
        File src = (File) jarIter.next();
        String path = src.getPath().replace(File.separatorChar, '/');
        bundleProperties.addToExtraClassPath(path);
    }
}