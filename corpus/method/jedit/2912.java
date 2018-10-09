/**
	 * Handles a message sent on the EditBus.
	 *
	 * This method must specify the type of responses the plugin will have
	 * for various subclasses of the {@link EBMessage} class. Typically
	 * this is done with one or more <code>if</code> blocks that test
	 * whether the message is an instance of a derived message class in
	 * which the component has an interest. For example:
	 *
	 * <pre> if(msg instanceof BufferUpdate) {
	 *     // a buffer's state has changed!
	 * }
	 * else if(msg instanceof ViewUpdate) {
	 *     // a view's state has changed!
	 * }
	 * // ... and so on</pre>
	 *
	 * @param message The message
	 */
void handleMessage(EBMessage message);