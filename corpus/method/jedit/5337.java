//}}}
//{{{ _init() method
public void _init() {
    setLayout(new BorderLayout());
    add(BorderLayout.NORTH, createDockingOptionsPanel());
    add(BorderLayout.CENTER, createWindowTableScroller());
    add(BorderLayout.SOUTH, createDockingFrameworkChooser());
    dockableSetSelection.setModel(new DefaultComboBoxModel<String>(windowModel.getDockableSets().toArray(new String[0])));
}