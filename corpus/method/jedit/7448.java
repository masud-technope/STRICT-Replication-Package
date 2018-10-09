//}}}
//{{{ toggleFullScreen() method
public void toggleFullScreen() {
    fullScreenMode = !fullScreenMode;
    GraphicsDevice sd = getGraphicsConfiguration().getDevice();
    dispose();
    if (fullScreenMode) {
        updateFullScreenProps();
        windowedBounds = getBounds();
        setUndecorated(true);
        setBounds(sd.getDefaultConfiguration().getBounds());
        validate();
    } else {
        boolean showStatus = plainView ? jEdit.getBooleanProperty("view.status.plainview.visible") : jEdit.getBooleanProperty("view.status.visible");
        if (menuBar != null && getJMenuBar() != menuBar)
            setJMenuBar(menuBar);
        boolean alternateLayout = jEdit.getBooleanProperty("view.toolbar.alternateLayout");
        loadToolBars();
        if (showStatus) {
            if (alternateLayout)
                addToolBar(BOTTOM_GROUP, STATUS_BAR_LAYER, status);
            else
                getContentPane().add(BorderLayout.SOUTH, status);
        }
        setUndecorated(false);
        setBounds(windowedBounds);
    }
    setVisible(true);
    toFront();
    closeAllMenus();
    // so you can keep typing in your editpane afterwards...
    editPane.getTextArea().requestFocus();
    EditBus.send(new ViewUpdate(this, ViewUpdate.FULL_SCREEN_TOGGLED));
}