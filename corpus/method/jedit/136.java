//
// Write the PkgInfo file into the application bundle
//
private void writePkgInfo() throws BuildException {
    File pkgInfo = new File(mContentsDir, "PkgInfo");
    PrintWriter writer = null;
    try {
        writer = new PrintWriter(new BufferedWriter(new FileWriter(pkgInfo)));
        writer.print(bundleProperties.getCFBundlePackageType());
        writer.println(bundleProperties.getCFBundleSignature());
        writer.flush();
    } catch (IOException ex) {
        throw new BuildException("Cannot create PkgInfo file: " + ex);
    } finally {
        mFileUtils.close(writer);
    }
}