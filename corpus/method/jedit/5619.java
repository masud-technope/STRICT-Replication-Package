//}}}
//{{{ breakPlugin() method
private void breakPlugin() {
    plugin = new EditPlugin.Broken(this, plugin.getClassName());
    // remove action sets, dockables, etc so that user doesn't
    // see the broken plugin
    uninit(false);
    // but we want properties to hang around
    jEdit.addPluginProps(properties);
}