/**
	 * Setter for the "name" attribute (required) This attribute names the
	 * output application bundle and asks as the CFBundleName if 'bundlename' is
	 * not specified
	 */
public void setName(String s) {
    bundleProperties.setApplicationName(s);
}