// }}}
// {{{ propertiesChanged
protected void propertiesChanged() {
    if (view.isPlainView())
        return;
    boolean newAlternateLayout = jEdit.getBooleanProperty(ALTERNATE_LAYOUT_PROP);
    if (newAlternateLayout != alternateLayout) {
        alternateLayout = newAlternateLayout;
        applyAlternateLayout(newAlternateLayout);
    }
    String[] dockables = factory.getRegisteredDockableWindows();
    for (String dockable : dockables) {
        String oldPosition = positions.get(dockable);
        String newPosition = getDockablePosition(dockable);
        if (oldPosition == null || !newPosition.equals(oldPosition)) {
            positions.put(dockable, newPosition);
            dockingPositionChanged(dockable, oldPosition, newPosition);
        }
    }
}