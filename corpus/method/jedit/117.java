/**
	 * Setter for the "icon" attribute (optional)
	 */
public void setIcon(File f) {
    mAppIcon = f;
    bundleProperties.setCFBundleIconFile(f.getName());
}