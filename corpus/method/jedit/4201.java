//{{{ skipWindow method
/**
		 * Check if a window is not top level or systray icon
		 * @param window the checked window
		 * @return true if it is not toplevel or systray icon
		 */
private boolean skipWindow(Window window) {
    if (window.getClass().getName().contains("Tray"))
        return true;
    return false;
//}}}
}