public void run() {
    try {
        while (doWork) {
            drain();
            Thread.sleep(SLEEP_TIME);
        }
    } catch (Exception exc) {
        Log.log(Log.ERROR, this, exc);
    }
    doWork = false;
    th = null;
}