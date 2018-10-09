//}}}
//{{{ isCaseInsensitiveFS() method
/**
	 * @since jEdit 4.3pre2
	 */
public static boolean isCaseInsensitiveFS() {
    return isWindows() || isMacOS();
}