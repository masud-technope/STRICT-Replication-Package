//}}}
//{{{ log() method
/**
	 * Logs an exception with a message.
	 *
	 * If an exception is the cause of a call to {@link #log}, then
	 * the exception should be explicitly provided so that it can
	 * be presented to the (debugging) user in a useful manner
	 * (not just the exception message, but also the exception stack trace)
	 *
	 * @since jEdit 4.3pre5
	 */
public static void log(int urgency, Object source, Object message, Throwable exception) {
    // We can do nicer here, but this is a start...
    log(urgency, source, message);
    log(urgency, source, exception);
}