//}}}
//{{{ uninit() method
public void uninit(boolean exit) {
    deactivatePlugin(exit);
    if (!exit) {
        for (String path : weRequireThese) {
            PluginJAR jar = jEdit.getPluginJAR(path);
            if (jar != null)
                jar.theseRequireMe.remove(this.path);
        }
        for (String path : weUseThese) {
            PluginJAR jar = jEdit.getPluginJAR(path);
            if (jar != null)
                jar.theseUseMe.remove(this.path);
        }
        classLoader.deactivate();
        BeanShell.resetClassManager();
        if (actions != null)
            jEdit.removeActionSet(actions);
        if (browserActions != null)
            VFSBrowser.getActionContext().removeActionSet(browserActions);
        DockableWindowFactory.getInstance().unloadDockableWindows(this);
        ServiceManager.unloadServices(this);
        jEdit.removePluginProps(properties);
        if (localizationProperties != null) {
            Collection<Properties> values = localizationProperties.values();
            for (Properties value : values) {
                jEdit.removePluginLocalizationProps(value);
            }
        }
        try {
            if (zipFile != null) {
                zipFile.close();
                zipFile = null;
            }
        } catch (IOException io) {
            Log.log(Log.ERROR, this, io);
        }
        removePluginCache();
    }
}