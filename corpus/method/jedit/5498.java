///}}}
//{{{ _save() method
@Override
protected void _save() {
    jEdit.setColorProperty("view.status.foreground", foregroundColor.getSelectedColor());
    jEdit.setColorProperty("view.status.background", backgroundColor.getSelectedColor());
    jEdit.setColorProperty("view.status.memory.foreground", memForegroundColor.getSelectedColor());
    jEdit.setColorProperty("view.status.memory.background", memBackgroundColor.getSelectedColor());
    jEdit.setBooleanProperty("view.status.visible", showStatusbar.isSelected());
    jEdit.setBooleanProperty("view.status.plainview.visible", showStatusbarPlain.isSelected());
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < listModel.getSize(); i++) {
        if (i != 0)
            buf.append(' ');
        String widgetName = (String) listModel.elementAt(i);
        buf.append(widgetName);
    }
    jEdit.setProperty("view.status", buf.toString());
    jEdit.setBooleanProperty("view.status.show-caret-linenumber", showCaretLineNumber.isSelected());
    jEdit.setBooleanProperty("view.status.show-caret-dot", showCaretDot.isSelected());
    jEdit.setBooleanProperty("view.status.show-caret-virtual", showCaretVirtual.isSelected());
    jEdit.setBooleanProperty("view.status.show-caret-offset", showCaretOffset.isSelected());
    jEdit.setBooleanProperty("view.status.show-caret-bufferlength", showCaretBufferLength.isSelected());
}