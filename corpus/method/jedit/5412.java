//}}}
//{{{ selectMode() method
private void selectMode() {
    int index = mode.getSelectedIndex() < 0 ? 0 : mode.getSelectedIndex();
    current = index == 0 ? global : modeProps[index - 1];
    current.edited = true;
    current.load();
    captionBox.removeAll();
    captionBox.add(GUIUtilities.createMultilineLabel(jEdit.getProperty("options.editing.caption-" + (index == 0 ? "0" : "1"))));
    useDefaults.setSelected(current.useDefaults);
    filenameGlob.setText(current.filenameGlob);
    firstlineGlob.setText(current.firstlineGlob);
    noWordSep.setText(current.noWordSep);
    camelCasedWords.setSelected(current.camelCasedWords);
    folding.setSelectedItem(current.folding);
    collapseFolds.setText(current.collapseFolds);
    wrap.setSelectedItem(current.wrap);
    maxLineLen.setSelectedItem(current.maxLineLen);
    tabSize.setSelectedItem(current.tabSize);
    indentSize.setSelectedItem(current.indentSize);
    noTabs.setSelected(current.noTabs);
    elasticTabstops.setSelected(current.elasticTabstops);
    autoIndent.setSelectedItem(current.autoIndent);
    deepIndent.setSelected(current.deepIndent);
    updateEnabled();
    revalidate();
}