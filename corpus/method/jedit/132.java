/**
	 * Setter for the version attribute (optional). It is this property, not
	 * CFBundleVersion, which should receive the `short' version string. See for
	 * example
	 * <http://developer.apple.com/documentation/MacOSX/Conceptual/BPRuntimeConfig/>
	 */
public void setVersion(String s) {
    bundleProperties.setCFBundleShortVersionString(s);
}