/** Wait for all IO tasks to finish
	 * @since jEdit 5.1pre1
	 */
public void waitForIoTasks() {
    synchronized (ioWaitLock) {
        while (countIoTasks() > 0) {
            try {
                ioWaitLock.wait();
            } catch (InterruptedException e) {
                Log.log(Log.ERROR, this, e);
            }
        }
    }
    AwtRunnableQueue.INSTANCE.queueAWTRunner(true);
}