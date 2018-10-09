//}}}
//{{{ isMainThread() method
/**
	 * Returns true if the currently running thread is the main thread.
	 * @since jEdit 4.2pre1
	 */
public static boolean isMainThread() {
    return Thread.currentThread() == mainThread;
}