//}}}
//{{{ loadPluginSet() method
boolean loadPluginSet(String path) {
    VFS vfs = VFSManager.getVFSForPath(path);
    Object session = vfs.createVFSSession(path, this);
    try {
        InputStream is = vfs._createInputStream(session, path, false, this);
        XMLUtilities.parseXML(is, new ManagePanelRestoreHandler());
        is.close();
        int rowCount = pluginModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Entry ent = pluginModel.getEntry(i);
            String name = ent.name;
            if (name != null) {
                pluginModel.setValueAt(selectedPlugins.contains(name), i, 0);
            } else {
                String jarPath = ent.jar;
                String jarName = jarPath.substring(1 + jarPath.lastIndexOf(File.separatorChar));
                try {
                    pluginModel.setValueAt(jarNames.contains(jarName), i, 0);
                } catch (Exception e) {
                    Log.log(Log.WARNING, this, "Exception thrown loading: " + jarName, e);
                }
            }
        }
    } catch (Exception e) {
        Log.log(Log.ERROR, this, "Loading Pluginset Error", e);
        return false;
    }
    pluginModel.update();
    return true;
}