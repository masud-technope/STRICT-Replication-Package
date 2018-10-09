//}}}
//{{{ _save() method
public void _save() {
    jEdit.setBooleanProperty(AUTO_LOAD_MODE_LAYOUT_PROP, autoLoadModeLayout.isSelected());
    jEdit.setBooleanProperty(AUTO_SAVE_MODE_LAYOUT_PROP, autoSaveModeLayout.isSelected());
    jEdit.setProperty(View.VIEW_DOCKING_FRAMEWORK_PROPERTY, (String) dockingFramework.getSelectedItem());
    windowModel.save();
}