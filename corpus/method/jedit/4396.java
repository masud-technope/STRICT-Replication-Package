//}}}
//{{{ handlePluginUpdate() method
@EBHandler
public void handlePluginUpdate(PluginUpdate pmsg) {
    if (pmsg.getWhat() == PluginUpdate.LOADED || pmsg.getWhat() == PluginUpdate.UNLOADED) {
        if (!pmsg.isExiting()) {
            if (!queuedTOCReload)
                queueTOCReload();
            queuedTOCReload = true;
        }
    }
}