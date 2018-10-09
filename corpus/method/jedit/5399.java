//}}}
//{{{ setGutterComponentsEnabledState
private void setGutterComponentsEnabledState() {
    GenericGUIUtilities.setEnabledRecursively(gutterComponents, gutterEnabled.isSelected());
}