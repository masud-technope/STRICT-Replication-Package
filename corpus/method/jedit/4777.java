//}}}
//{{{ isStartupDone() method
/**
	 * Whether jEdit startup is over.
	 * @since jEdit 4.3pre17
	 */
public static boolean isStartupDone() {
    return (!startupDone.contains(false));
}