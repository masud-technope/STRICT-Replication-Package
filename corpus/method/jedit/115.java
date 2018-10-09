/**
	 * Override the stub file path to build on non-MacOS platforms
	 *
	 * @param file
	 *            the path to the stub file
	 */
public void setStubFile(File file) {
    mStubFile = (file.exists()) ? file : new File(DEFAULT_STUB);
    bundleProperties.setCFBundleExecutable(file.getName());
}