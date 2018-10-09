//}}}
//{{{ show() method
// see notes below		
@SuppressWarnings({ "deprecation" })
public void show(DockableWindowManagerImpl.Entry entry) {
    if (current == entry) {
        if (entry != null) {
            if (entry.win instanceof DefaultFocusComponent) {
                ((DefaultFocusComponent) entry.win).focusOnDefaultComponent();
            } else {
                // TODO: requestDefaultFocus is deprecated, fix this
                entry.win.requestDefaultFocus();
            }
        }
        return;
    }
    if (entry != null) {
        if (current == null) {
            // we didn't have a component previously, so
            // create a border
            dockablePanel.setBorder(new DockBorder(position));
        }
        mostRecent = entry.factory.name;
        this.current = entry;
        if (entry.win.getParent() != dockablePanel)
            dockablePanel.add(entry.factory.name, entry.win);
        dockablePanel.showDockable(entry.factory.name);
        entry.btn.setSelected(true);
        if (entry.win instanceof DefaultFocusComponent) {
            ((DefaultFocusComponent) entry.win).focusOnDefaultComponent();
        } else {
            // TODO: requestDefaultFocus is deprecated, fix this
            entry.win.requestDefaultFocus();
        }
    } else {
        if (current != null) {
            Object reason = DockableWindowUpdate.DEACTIVATED;
            EditBus.send(new DockableWindowUpdate(wm, reason, current.factory.name));
        }
        current = null;
        nullButton.setSelected(true);
        // removing last component, so remove border
        dockablePanel.setBorder(null);
        wm.getView().getTextArea().requestFocus();
    }
    wm.revalidate();
    dockablePanel.repaint();
}