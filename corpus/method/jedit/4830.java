//}}}
//{{{ propertiesChanged() method
/**
	 * Reloads various settings from the properties.
	 */
public static void propertiesChanged() {
    initPLAF();
    keymapManager.reload();
    initKeyBindings();
    Autosave.setInterval(getIntegerProperty("autosave", 30));
    saveCaret = getBooleanProperty("saveCaret");
    UIDefaults defaults = UIManager.getDefaults();
    defaults.put("SplitPane.continuousLayout", true);
    // give all text areas the same font
    Font font = getFontProperty("view.font");
    //defaults.put("TextField.font",font);
    defaults.put("TextArea.font", font);
    defaults.put("TextPane.font", font);
    // Enable/Disable tooltips
    ToolTipManager.sharedInstance().setEnabled(jEdit.getBooleanProperty("showTooltips"));
    initProxy();
    // we do this here instead of adding buffers to the bus.
    Buffer buffer = buffersFirst;
    while (buffer != null) {
        buffer.resetCachedProperties();
        buffer.propertiesChanged();
        buffer = buffer.next;
    }
    HistoryModel.setDefaultMax(getIntegerProperty("history", 25));
    HistoryModel.setDefaultMaxSize(getIntegerProperty("historyMaxSize", 5000000));
    KillRing.getInstance().propertiesChanged(getIntegerProperty("history", 25));
    Chunk.propertiesChanged(propertyManager);
    Log.setBeepOnOutput(jEdit.getBooleanProperty("debug.beepOnOutput"));
    if (getBooleanProperty("systrayicon")) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JTrayIconManager.addTrayIcon();
            }
        });
    } else {
        JTrayIconManager.removeTrayIcon();
    }
    EditBus.send(new PropertiesChanged(null));
}