//}}}
public static void setMaxLines(int newMax) {
    if (newMax == MAXLINES)
        return;
    // find last non-null entry in log array
    int lineCount = 0;
    for (int i = 0; i < log.length; i++) {
        if (log[i] == null)
            break;
        ++lineCount;
    }
    // copy entries from log to newLog
    String[] newLog = new String[newMax];
    if (newMax > lineCount) {
        System.arraycopy(log, 0, newLog, 0, lineCount);
    } else {
        // lineCount > newMax
        System.arraycopy(log, lineCount - newMax, newLog, 0, newMax);
        logLineCount = newMax;
    }
    MAXLINES = newMax;
    log = newLog;
    listModel.update(lineCount, true);
}