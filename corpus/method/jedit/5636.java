@Override
public void valueChanged(ListSelectionEvent e) {
    String text = getText();
    if (table.getSelectedRowCount() == 1) {
        Entry entry = (Entry) pluginModel.filteredEntries.get(table.getSelectedRow());
        String pattern = "<b>{0}</b>: {1}<br><b>{2}</b>: {3}<br><br>{4}";
        List<String> params = new ArrayList<String>();
        params.add(jEdit.getProperty("install-plugins.info.author", "Author"));
        params.add(entry.author);
        params.add(jEdit.getProperty("install-plugins.info.released", "Released"));
        params.add(entry.date);
        params.add(entry.description);
        if (entry.dependencies != null && !entry.dependencies.isEmpty()) {
            pattern += "<br><br><b>{5}</b>:<br>{6}";
            params.add(jEdit.getProperty("install-plugins.info.depends", "Depends on"));
            StringList sl = StringList.split(entry.dependencies, "\n");
            params.add(sl.join(", "));
        }
        text = MessageFormat.format(pattern, params.toArray());
    }
    setText(text);
    setCaretPosition(0);
    putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
}