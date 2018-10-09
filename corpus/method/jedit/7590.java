//}}}
//{{{ log() method
/**
	 * Logs a message. This method is thread-safe.<p>
	 *
	 * The following code sends a typical debugging message to the activity
	 * log:
	 * <pre>Log.log(Log.DEBUG,this,"counter = " + counter);</pre>
	 * The corresponding activity log entry might read as follows:
	 * <pre>[debug] JavaParser: counter = 15</pre>
	 *
	 * @param urgency The urgency; can be one of
	 * <code>Log.DEBUG</code>, <code>Log.MESSAGE</code>,
	 * <code>Log.NOTICE</code>, <code>Log.WARNING</code>, or
	 * <code>Log.ERROR</code>.
	 * @param source The source of the message, either an object or a
	 * class instance. When writing log messages from macros, set
	 * this parameter to <code>BeanShell.class</code> to make macro
	 * errors easier to spot in the activity log.
	 * @param message The message. This can either be a string or
	 * an exception
	 *
	 * @since jEdit 2.2pre2
	 */
public static void log(int urgency, Object source, Object message) {
    String _source;
    if (source == null) {
        _source = Thread.currentThread().getName();
        if (_source == null) {
            _source = Thread.currentThread().getClass().getName();
        }
    } else if (source instanceof Class)
        _source = ((Class<?>) source).getName();
    else
        _source = source.getClass().getName();
    int index = _source.lastIndexOf('.');
    if (index != -1)
        _source = _source.substring(index + 1);
    if (message instanceof Throwable) {
        _logException(urgency, source, (Throwable) message);
    } else {
        String _message = String.valueOf(message);
        // the output to get mixed up
        synchronized (LOCK) {
            StringTokenizer st = new StringTokenizer(_message, "\r\n");
            int lineCount = 0;
            boolean oldWrap = wrap;
            while (st.hasMoreTokens()) {
                lineCount++;
                _log(urgency, _source, st.nextToken().replace('\t', ' '));
            }
            listModel.update(lineCount, oldWrap);
        }
    }
}