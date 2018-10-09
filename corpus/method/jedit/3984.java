//}}}
//{{{ advance() methods
public synchronized void advance() {
    logAdvanceTime(null);
    progress++;
    repaint();
    if (realSplash == null) {
        // continuously
        try {
            wait();
        } catch (InterruptedException ie) {
            Log.log(Log.ERROR, this, ie);
        }
    }
}