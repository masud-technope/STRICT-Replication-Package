//{{{ update() method
void update(final int lineCount, final boolean oldWrap) {
    if (lineCount == 0 || listeners.isEmpty())
        return;
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            if (wrap) {
                if (oldWrap)
                    fireIntervalRemoved(0, lineCount - 1);
                else {
                    fireIntervalRemoved(0, logLineCount);
                }
                fireIntervalAdded(MAXLINES - lineCount + 1, MAXLINES);
            } else {
                fireIntervalAdded(logLineCount - lineCount + 1, logLineCount);
            }
        }
    });
//}}}
}