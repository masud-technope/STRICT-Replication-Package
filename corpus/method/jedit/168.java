// Copy the application stub into the bundle
// /////////////////////////////////////////////
private void copyApplicationStub() throws BuildException {
    File newStubFile = new File(mMacOsDir, bundleProperties.getCFBundleExecutable());
    if (mVerbose)
        log("Copying Java application stub to \"" + bundlePath(newStubFile) + "\"");
    try {
        mFileUtils.copyFile(mStubFile, newStubFile);
    } catch (IOException ex) {
        throw new BuildException("Cannot copy Java Application Stub: " + ex);
    }
    // Set the permissions on the stub file to executable
    setExecutable(newStubFile);
}