//}}}
//{{{ save() methods
protected void _save() {
    if (currentPane != null)
        jEdit.setProperty(getName() + ".last", currentPane.getName());
    int dividerPosition = splitter.getDividerLocation();
    jEdit.setIntegerProperty(optionGroup.getName() + ".splitter", dividerPosition);
    save(optionGroup);
}