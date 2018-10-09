//}}}
//{{{ _init() method
@Override
protected void _init() {
    JTabbedPane tabs = new JTabbedPane();
    modeSettings = new ModeSettingsPane();
    modeSettings._init();
    editModes = new EditModesPane();
    editModes._init();
    undoSettings = new UndoPane();
    undoSettings._init();
    tabs.addTab("Mode Settings", modeSettings);
    tabs.addTab("Edit Modes", editModes);
    tabs.addTab("Undo Settings", undoSettings);
    add(tabs);
}