public void run() {
    int requestCount = TaskManager.instance.countIoTasks();
    if (requestCount == 0) {
        getContentPane().setCursor(Cursor.getDefaultCursor());
    } else if (requestCount >= 1) {
        getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }
}