/**
	 * Utility method to determine whether this app bundle is targeting a 1.3 or
	 * 1.4 VM. The Mac OS X 1.3 VM uses different Java property names from the
	 * 1.4 VM to hint at native Mac OS X look and feel options. For example, on
	 * 1.3 the Java property to tell the VM to display Swing menu bars as screen
	 * menus is "com.apple.macos.useScreenMenuBar". Under 1.4, it becomes
	 * "apple.laf.useScreenMenuBar". Such is the price of progress, I suppose.
	 *
	 * Obviously, this logic may need refactoring in the future.
	 */
private boolean useOldPropertyNames() {
    return (bundleProperties.getJavaVersion() <= 1.3);
}