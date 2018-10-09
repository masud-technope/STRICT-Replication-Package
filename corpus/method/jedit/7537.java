//}}}
//{{{ start() method
/**
	 * Queue the AWT runner for the first time.
	 */
public void start() {
    synchronized (this) {
        awtQueueStarted = true;
    }
    queueAWTRunner(false);
}