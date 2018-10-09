@EBHandler
public void handlePropertiesChanged(PropertiesChanged msg) {
    // while this might be questionable, some
    // menus depend on properties
    menuOutOfDate = true;
}