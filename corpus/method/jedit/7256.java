//}}}
//{{{ dispose() method
/**
	 * Plugins and macros should not call this method.
	 * @since jEdit 4.2pre1
	 */
public void dispose() {
    DisplayManager.textAreaDisposed(this);
    gutter.dispose();
}