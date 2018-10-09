//}}}
//{{{ _logException() method
private static void _logException(final int urgency, final Object source, final Throwable message) {
    PrintStream out = createPrintStream(urgency, source);
    if (urgency >= level) {
        synchronized (throwables) {
            if (throwables.size() == MAX_THROWABLES) {
                throwables.remove(0);
            }
            throwables.add(message);
        }
    }
    synchronized (LOCK) {
        message.printStackTrace(out);
    }
}