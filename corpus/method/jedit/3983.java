public synchronized void advance(String label) {
    logAdvanceTime(label);
    progress++;
    this.label = label;
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