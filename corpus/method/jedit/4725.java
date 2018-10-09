//}}}
//{{{ runInAWTThread() method
/**
	 * Executes the specified runnable in the AWT thread once all
	 * pending I/O requests are complete. Only in one case the
	 * <code>Runnable</code> is executed directly: when the current thread
	 * is EDT and there are no I/O requests active or queued
	 * at the moment of call.
	 * @since jEdit 2.5pre1
	 * @deprecated Using that method, when you run a task in AWT Thread,
	 * it will wait for all background task causing some unwanted delays.
	 * If you need calling a task after a background work, please add your
	 * runnable to the EDT thread yourself at the end of the background task
	 * @see org.gjt.sp.util.ThreadUtilities#runInDispatchThread(Runnable)
	 * @see org.gjt.sp.util.ThreadUtilities#runInDispatchThreadAndWait(Runnable)
	 */
@Deprecated
public static void runInAWTThread(Runnable run) {
    AwtRunnableQueue.INSTANCE.runAfterIoTasks(run);
}