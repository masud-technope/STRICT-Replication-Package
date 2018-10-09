public void startThread() {
    if (th == null) {
        th = new Thread(this);
        doWork = true;
        th.start();
    }
}