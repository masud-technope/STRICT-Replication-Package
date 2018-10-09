public void handleMessage(EBMessage msg) {
    if (msg instanceof PropertiesChanged) {
        synchronized (lock) {
            colors = null;
        }
    }
}