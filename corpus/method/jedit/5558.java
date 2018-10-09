/**
		 * @return true if the uri points to a remote file
		 */
public static boolean skipRemote(String uri) {
    if (jEdit.getBooleanProperty("restore.remote"))
        return false;
    if (MiscUtilities.isURL(uri)) {
        String protocol = MiscUtilities.getProtocolOfURL(uri);
        if (!protocol.equals("file"))
            return true;
    }
    return false;
}