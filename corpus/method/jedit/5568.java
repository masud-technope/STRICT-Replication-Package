//}}}
//{{{ isPerspectiveEnabled() method
/**
	 * We disable saving of the perspective while the 'close all' dialog is
	 * showing.
	 * @since jEdit 4.3pre2
	 */
public static boolean isPerspectiveEnabled() {
    return enabled;
}