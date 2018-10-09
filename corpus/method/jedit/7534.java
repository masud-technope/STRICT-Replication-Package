public void run() {
    Runnable nextRunnable;
    // enable queuing of AWT runner again
    synchronized (AwtRunnableQueue.this) {
        awtRunnerQueued = false;
        nextRunnable = awtQueue.peek();
    }
    while (TaskManager.instance.countIoTasks() == 0 && nextRunnable != null) {
        doAWTRequest(nextRunnable);
        synchronized (AwtRunnableQueue.this) {
            // consume current entry
            awtQueue.poll();
            nextRunnable = awtQueue.peek();
        }
    }
}