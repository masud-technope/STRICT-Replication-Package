//}}}
//{{{ _log() method
private static void _log(int urgency, String source, String message) {
    String fullMessage = timeFormat.format(new Date()) + " [" + Thread.currentThread().getName() + "] [" + urgencyToString(urgency) + "] " + source + ": " + message;
    try {
        log[logLineCount] = fullMessage;
        if (++logLineCount >= log.length) {
            wrap = true;
            logLineCount = 0;
        }
        if (stream != null) {
            stream.write(fullMessage);
            stream.write(lineSep);
        }
    } catch (Exception e) {
        e.printStackTrace(realErr);
    }
    if (urgency >= level) {
        if (urgency == ERROR)
            realErr.println(fullMessage);
        else
            realOut.println(fullMessage);
        if (beepOnOutput) {
            long time = System.currentTimeMillis();
            if (time - lastBeepTime > 1000) {
                javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
                lastBeepTime = System.currentTimeMillis();
            }
        }
    }
}