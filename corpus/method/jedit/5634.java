 PluginInfoBox() {
    setBackground(jEdit.getColorProperty("view.bgColor"));
    setForeground(jEdit.getColorProperty("view.fgColor"));
    putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
    setContentType("text/html");
    setEditable(false);
    table.getSelectionModel().addListSelectionListener(this);
}