//}}}
//}}}
//{{{ Input handling
//{{{ getKeyEventInterceptor() method
/**
	 * Returns the listener that will handle all key events in this
	 * view, if any.
	 * @return the key event interceptor or null
	 */
public KeyListener getKeyEventInterceptor() {
    return inputHandler.getKeyEventInterceptor();
}