//}}}
//{{{ send() method
/**
	 * Sends a message to all components on the bus in turn.
	 * The message is delivered to components in the AWT thread,
	 * and this method will wait until all handlers receive the
	 * message before returning.
	 * <p>
	 * This method uses {@link ThreadUtilities#runInDispatchThreadNow},
	 * read the notes there for possible deadlocks.
	 *
	 * <p><b>NOTE:</b>
	 * If the calling thread is not the AWT thread and the
	 * thread is interrupted before or while the call of this
	 * method, this method can return before completion of handlers.
	 * However, the interruption state is set in this case, so the
	 * caller can detect the interruption after the call. If you
	 * really need the completion of handlers, you should make sure
	 * the call is in the AWT thread or the calling thread is never
	 * interrupted. If you don't care about the completion of
	 * handlers, it is recommended to use
	 * {@link #sendAsync(EBMessage)} instead.
	 * </p>
	 *
	 * @param message The message
	 */
public static void send(EBMessage message) {
    Runnable sender = new SendMessage(message);
    if (EventQueue.isDispatchThread()) {
        sender.run();
    } else {
        ThreadUtilities.runInDispatchThreadNow(sender);
    }
}