// Methods for copying FileSets into the application bundle ///////////////////////////////
// Files for the Contents/MacOS directory
private void processExecFileSets() {
    processCopyingFileSets(mExecFileSets, mMacOsDir, true);
}