/**
	 * Setter for the "shortname" attribute (optional) This key identifies the
	 * short name of the bundle. This name should be less than 16 characters
	 * long and be suitable for displaying in the menu and the About box. The
	 * name is (silently) cropped to this if necessary.
	 */
public void setShortName(String s) {
    bundleProperties.setCFBundleName(s);
}