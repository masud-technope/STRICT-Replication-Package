/**  Adrien Quillet, v2.5.0
	 * Setter for the "NSPreferencesContentSize" attribute (optional).
	 */
public void setContentSize(String s) {
    // Check input consistency
    String pattern = "[0-9]+,[0-9]+";
    if (!s.matches(pattern)) {
        throw new BuildException("Invalid content size format (expected 'width,height')");
    }
    bundleProperties.setNSPreferencesContentSize(s);
}