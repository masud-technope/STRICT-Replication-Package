//}}}
//{{{ getShortcut() method
/**
	 * Returns the shortcut, or null if the current shortcut should be
	 * removed or the dialog either has been cancelled. Use isOK()
	 * to determine if the latter is true.
	 */
public String getShortcut() {
    if (isOK)
        return shortcut.getShortcut();
    else
        return null;
}