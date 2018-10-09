// }}}
// {{{ handleDockableWindowUpdate() method
@EBHandler
public void handleDockableWindowUpdate(DockableWindowUpdate msg) {
    if (msg.getWhat() == DockableWindowUpdate.PROPERTIES_CHANGED)
        propertiesChanged();
}