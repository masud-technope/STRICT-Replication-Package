//}}}
//{{{ handlePluginUpdate() method
@EBHandler
public void handlePluginUpdate(PluginUpdate pmsg) {
    if ((pmsg.getWhat() == PluginUpdate.LOADED || pmsg.getWhat() == PluginUpdate.UNLOADED) && plugins != null) /* plugins can be null if the VFSBrowser menu bar is hidden */
    {
        plugins.updatePopupMenu();
    }
}