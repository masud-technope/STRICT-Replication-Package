///}}}
//{{{ _save() method
protected void _save() {
    jEdit.setBooleanProperty("view.showToolbar", showToolbar.isSelected());
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < listModel.getSize(); i++) {
        if (i != 0)
            buf.append(' ');
        Button button = (Button) listModel.elementAt(i);
        buf.append(button.actionName);
        jEdit.setProperty(button.actionName + ".icon", button.iconName);
    }
    jEdit.setProperty("view.toolbar", buf.toString());
}