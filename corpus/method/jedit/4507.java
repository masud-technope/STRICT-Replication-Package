//}}}
//{{{ setKeyEventInterceptor() method
/**
	 * Sets the listener that will handle all key events in this
	 * view. For example, the complete word command uses this so
	 * that all key events are passed to the word list popup while
	 * it is visible.
	 * @param keyEventInterceptor the KeyListener that will receive the events
	 */
public void setKeyEventInterceptor(KeyListener keyEventInterceptor) {
    this.keyEventInterceptor = keyEventInterceptor;
}