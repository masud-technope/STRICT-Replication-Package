//}}}
//{{{ hasScreenMenuBar() method
/**
	 * Returns whether the screen menu bar on Mac OS X is in use.
	 * @since jEdit 4.2pre1
	*/
public static boolean hasScreenMenuBar() {
    if (!isMacOS())
        return false;
    else if (hasScreenMenuBar == -1) {
        String result = System.getProperty("apple.laf.useScreenMenuBar");
        if (result == null)
            result = System.getProperty("com.apple.macos.useScreenMenuBar");
        hasScreenMenuBar = "true".equals(result) ? 1 : 0;
    }
    return hasScreenMenuBar == 1;
}