//}}}
//{{{ createPopupMenu() method
public JPopupMenu createPopupMenu(final DockableWindowContainer container, final String dockable, final boolean clone) {
    JPopupMenu popup = new JPopupMenu();
    if (dockable == null && container instanceof PanelWindowContainer) {
        ActionListener listener = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                showDockableWindow(evt.getActionCommand());
            }
        };
        String[] dockables = ((PanelWindowContainer) container).getDockables();
        Map<String, String> dockableMap = new TreeMap<String, String>();
        for (String action : dockables) dockableMap.put(getDockableTitle(action), action);
        for (Map.Entry<String, String> entry : dockableMap.entrySet()) {
            JMenuItem item = new JMenuItem(entry.getKey());
            item.setActionCommand(entry.getValue());
            item.addActionListener(listener);
            popup.add(item);
        }
    } else {
        JMenuItem caption = new JMenuItem(getDockableTitle(dockable));
        caption.setEnabled(false);
        popup.add(caption);
        popup.addSeparator();
        String currentPos = jEdit.getProperty(dockable + ".dock-position", FLOATING);
        if (!clone) {
            String[] positions = { FLOATING, TOP, LEFT, BOTTOM, RIGHT };
            for (final String pos : positions) {
                if (pos.equals(currentPos))
                    continue;
                JMenuItem moveMenuItem = new JMenuItem(jEdit.getProperty("view.docking.menu-" + pos));
                moveMenuItem.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        jEdit.setProperty(dockable + ".dock-position", pos);
                        EditBus.send(new DockableWindowUpdate(DockableWindowManagerImpl.this, DockableWindowUpdate.PROPERTIES_CHANGED, dockable));
                        showDockableWindow(dockable);
                    }
                });
                popup.add(moveMenuItem);
            }
            popup.addSeparator();
        }
        JMenuItem cloneMenuItem = new JMenuItem(jEdit.getProperty("view.docking.menu-clone"));
        cloneMenuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                floatDockableWindow(dockable);
            }
        });
        popup.add(cloneMenuItem);
        popup.addSeparator();
        JMenuItem closeMenuItem = new JMenuItem(jEdit.getProperty("view.docking.menu-close"));
        closeMenuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                if (clone)
                    ((FloatingWindowContainer) container).dispose();
                else
                    removeDockableWindow(dockable);
            }
        });
        popup.add(closeMenuItem);
        if (!(clone || currentPos.equals(FLOATING))) {
            JMenuItem undockMenuItem = new JMenuItem(jEdit.getProperty("view.docking.menu-undock"));
            undockMenuItem.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent evt) {
                    jEdit.setProperty(dockable + ".dock-position", FLOATING);
                    EditBus.send(new DockableWindowUpdate(DockableWindowManagerImpl.this, DockableWindowUpdate.PROPERTIES_CHANGED, dockable));
                    // Reset the window, propertiesChanged() doesn't
                    // reset it for MOVABLE windows.
                    Entry entry = windows.get(dockable);
                    if (entry == null)
                        Log.log(Log.ERROR, this, "Unknown dockable window: " + dockable);
                    else
                        entry.win = null;
                }
            });
            popup.add(undockMenuItem);
        }
    }
    return popup;
}