//}}}
//{{{ handleClient() method
/**
	 * @param restore Ignored unless no views are open
	 * @param parent The client's parent directory
	 * @param args A list of files. Null entries are ignored, for convinience
	 * @since jEdit 3.2pre7
	 */
public static void handleClient(boolean restore, String parent, String[] args) {
    handleClient(restore, false, false, parent, args);
}