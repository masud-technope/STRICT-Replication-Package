//}}}
//{{{ getEditServer() method
/**
	 * Returns the edit server instance. You can use this to find out the
	 * port number jEdit is listening on.
	 * @since jEdit 4.2pre10
	 */
public static EditServer getEditServer() {
    return server;
}