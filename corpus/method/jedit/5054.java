@EBHandler
public void handleDynamicMenuChanged(DynamicMenuChanged msg) {
    if (name.equals(msg.getMenuName()))
        menuOutOfDate = true;
}