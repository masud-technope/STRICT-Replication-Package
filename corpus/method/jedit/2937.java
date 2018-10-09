//}}}
//{{{ sendAsync() method
/**
	 * Schedules a message to be sent on the edit bus as soon as
	 * the AWT thread is done processing current events. The
	 * method returns immediately (i.e., before the message is
	 * sent).
	 *
	 * @param message The message
	 *
	 * @since jEdit 4.4pre1
	 */
public static void sendAsync(EBMessage message) {
    EventQueue.invokeLater(new SendMessage(message));
}