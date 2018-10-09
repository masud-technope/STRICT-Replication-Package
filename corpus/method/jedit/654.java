//}}}
//{{{ isScriptRunning() method
/**
	 * @return if a BeanShell script or macro is currently running.
	 * @since jEdit 2.7pre2
	 */
public static boolean isScriptRunning() {
    return running;
}