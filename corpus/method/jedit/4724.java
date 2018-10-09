//}}}
//{{{ runInWorkThread() method
/**
	 * Executes the specified runnable in one of the I/O threads.
	 * @since jEdit 2.6pre2
	 * @deprecated You should not use this method, this threadpool
	 * links the AWT Threads and Work threads.
	 * @see org.gjt.sp.util.ThreadUtilities#runInBackground(org.gjt.sp.util.Task)
	 * @see org.gjt.sp.util.ThreadUtilities#runInBackground(Runnable)
	 */
@Deprecated
public static void runInWorkThread(Task run) {
    if (!(run instanceof IoTask))
        throw new IllegalArgumentException();
    ThreadUtilities.runInBackground(run);
}