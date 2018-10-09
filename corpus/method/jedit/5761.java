//}}}
//{{{ setPlugin() method
void setPlugin(Entry entry) {
    if (entry != this.entry) {
        if (entry.status.equals(Entry.LOADED)) {
            if (entry.name == null)
                title.setText("<html><b>" + entry.jar + "</b></html>");
            else
                title.setText("<html><b>" + entry.name + "</b></html>");
            StringBuilder sb = new StringBuilder(256);
            // No problem on Sun's Java 6 JVM.
            if (entry.version != null)
                sb.append("<b>").append(jEdit.getProperty("install-plugins.info.version", "Version")).append("</b>: ").append(entry.version).append("<br>");
            if (entry.author != null)
                sb.append("<b>").append(jEdit.getProperty("install-plugins.info.author", "Author")).append("</b>: ").append(entry.author).append("<br>");
            if (entry.description != null) {
                sb.append("<br>").append(entry.description);
            }
            sb.append(getDepends(entry));
            pluginDetail.setText(sb.toString());
        } else {
            title.setText("<html><b>" + entry.jar + "</b></html>");
            PluginJAR pluginJar = new PluginJAR(new File(entry.jar));
            pluginJar.init();
            entry.plugin = pluginJar.getPlugin();
            String clazz = pluginJar.getPlugin().getClassName();
            StringBuilder sb = new StringBuilder(256);
            sb.append("<b>").append(jEdit.getProperty("install-plugin.info.version", "Version")).append("</b>: ").append(jEdit.getProperty("plugin." + clazz + ".version", ""));
            sb.append("<br><b>").append(jEdit.getProperty("install-plugin.info.author", "Author")).append("</b>: ").append(jEdit.getProperty("plugin." + clazz + ".author", ""));
            sb.append("<br><br>").append(jEdit.getProperty("plugin." + clazz + ".description", ""));
            sb.append(getDepends(entry));
            pluginDetail.setText(sb.toString());
            pluginJar.uninit(false);
        }
        pluginDetail.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
        this.entry = entry;
    }
}