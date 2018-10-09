//}}}
//{{{ load() method
/**
	 * Forces the action set to be loaded. Plugins and macros should not
	 * call this method.
	 * @since jEdit 4.2pre1
	 */
public void load() {
    if (loaded)
        return;
    loaded = true;
    if (uri == null)
        return;
    try {
        Log.log(Log.DEBUG, this, "Loading actions from " + uri);
        ActionListHandler ah = new ActionListHandler(uri.toString(), this);
        InputStream in;
        try {
            in = uri.openStream();
        } catch (FileNotFoundException e) {
            in = null;
            Log.log(Log.WARNING, this, "Unable to open: " + uri);
        }
        if (in != null && XMLUtilities.parseXML(in, ah)) {
            Log.log(Log.ERROR, this, "Unable to parse: " + uri);
        }
    } catch (IOException e) {
        Log.log(Log.ERROR, this, uri, e);
    }
}