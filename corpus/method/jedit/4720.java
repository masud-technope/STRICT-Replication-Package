//}}}
//}}}
//{{{ error() method
/**
	 * Handle an I/O error.
	 * @since jEdit 4.3pre3
	 */
public static void error(IOException e, String path, Component comp) {
    Log.log(Log.ERROR, VFSManager.class, e);
    VFSManager.error(comp, path, "ioerror", new String[] { e.toString() });
}