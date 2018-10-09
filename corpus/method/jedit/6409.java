/**
                 * @return true if the uri points to a file that is remote, that is, the
                 * protocol of the give uri is something other than 'file'.
                 */
public boolean isRemote(String uri) {
    if (MiscUtilities.isURL(uri)) {
        String protocol = MiscUtilities.getProtocolOfURL(uri);
        return !protocol.equals("file");
    }
    return false;
}