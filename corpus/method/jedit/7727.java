void fireDone(Task task) {
    tasks.remove(task);
    List<TaskListener> listeners = this.listeners;
    for (TaskListener listener : listeners) {
        listener.done(task);
    }
    if (task instanceof IoTask) {
        AwtRunnableQueue.INSTANCE.queueAWTRunner(false);
        synchronized (ioWaitLock) {
            ioWaitLock.notifyAll();
        }
    }
}