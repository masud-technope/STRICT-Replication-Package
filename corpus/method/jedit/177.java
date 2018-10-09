/**
	 * Setter for the "smalltabs" attribute (optional)
	 */
public void setSmallTabs(boolean b) {
    bundleProperties.addJavaProperty("com.apple.smallTabs", new Boolean(b).toString());
}