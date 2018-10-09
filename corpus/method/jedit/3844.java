public void actionPerformed(ActionEvent evt) {
    if (popup != null && popup.isVisible())
        popup.setVisible(false);
    if (evt.getSource() == closeBox)
        show((DockableWindowManagerImpl.Entry) null);
    else {
        if (wm.isDockableWindowVisible(evt.getActionCommand()))
            show((DockableWindowManagerImpl.Entry) null);
        else
            wm.showDockableWindow(evt.getActionCommand());
    }
}