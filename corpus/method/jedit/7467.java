//}}}
//{{{ setKeyEventInterceptor() method
/**
	 * Sets the listener that will handle all key events in this
	 * view. For example, the complete word command uses this so
	 * that all key events are passed to the word list popup while
	 * it is visible.
	 * @param listener The key event interceptor.
	 */
public void setKeyEventInterceptor(KeyListener listener) {
    inputHandler.setKeyEventInterceptor(listener);
}