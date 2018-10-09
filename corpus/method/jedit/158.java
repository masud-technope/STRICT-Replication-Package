// Methods for copying FileLists into the application bundle /////////////////////////////
// Files for the Contents/MacOS directory
private void processExecFileLists() throws BuildException {
    processCopyingFileLists(mExecFileLists, mMacOsDir, true);
}