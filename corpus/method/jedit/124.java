/**
	 * Setter for the "bundleid" attribute (optional) This key specifies a
	 * unique identifier string for the bundle. This identifier should be in the
	 * form of a Java-style package name, for example com.mycompany.myapp. The
	 * bundle identifier can be used to locate the bundle at runtime. The
	 * preferences system uses this string to identify applications uniquely.
	 *
	 * No default.
	 */
public void setBundleid(String s) {
    bundleProperties.setCFBundleIdentifier(s);
}