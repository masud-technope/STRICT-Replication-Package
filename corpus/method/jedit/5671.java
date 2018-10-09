//}}}
//{{{ loadPluginSet() method
/** loads a pluginSet xml file and updates the model to reflect
	    certain checked selections
	    @since jEdit 4.3pre10
	    @author Alan Ezust
	*/
boolean loadPluginSet(String path) {
    pluginSet.clear();
    pluginModel.clearSelection();
    VFS vfs = VFSManager.getVFSForPath(path);
    Object session = vfs.createVFSSession(path, InstallPanel.this);
    try {
        InputStream is = vfs._createInputStream(session, path, false, InstallPanel.this);
        XMLUtilities.parseXML(is, new StringMapHandler());
    } catch (Exception e) {
        Log.log(Log.WARNING, this, "Loading Pluginset failed:" + e.getMessage());
        return false;
    }
    pluginModel.update();
    return true;
}