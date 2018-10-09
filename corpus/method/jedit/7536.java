//}}}
//{{{ runAfterIoTasks() method
/**
	 * Adds a runnable to the AWT queue to run in the EDT 
	 * after all pending IO tasks are finished
	 * @param run The runnable to queue for execution in the EDT after all IO tasks
	 */
public void runAfterIoTasks(Runnable run) {
    boolean runDirectly = false;
    //{{{ if there are no requests, execute AWT requests immediately
    synchronized (this) {
        if (awtQueueStarted && TaskManager.instance.countIoTasks() == 0 && awtQueue.isEmpty())
            runDirectly = true;
    }
    if (runDirectly) {
        //			Log.log(Log.DEBUG,this,"AWT immediate: " + run);
        ThreadUtilities.runInDispatchThread(run);
        return;
    //}}}
    }
    synchronized (this) {
        awtQueue.offer(run);
    }
    // queue AWT request
    queueAWTRunner(false);
}