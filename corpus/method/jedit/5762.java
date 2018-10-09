//{{{ PluginDetailPanel constructor
 PluginDetailPanel() {
    setLayout(new BorderLayout());
    pluginDetail = new JEditorPane();
    pluginDetail.setEditable(false);
    pluginDetail.setContentType("text/html");
    pluginDetail.setBackground(jEdit.getColorProperty("view.bgColor"));
    pluginDetail.setForeground(jEdit.getColorProperty("view.fgColor"));
    pluginDetail.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
    title = new JLabel();
    add(title, BorderLayout.NORTH);
    JScrollPane scroll = new JScrollPane(pluginDetail);
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    add(scroll);
}