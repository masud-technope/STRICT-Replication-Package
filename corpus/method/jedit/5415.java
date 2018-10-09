//}}}
//{{{ saveMode() method
private void saveMode() {
    current.useDefaults = useDefaults.isSelected();
    current.filenameGlob = filenameGlob.getText();
    current.firstlineGlob = firstlineGlob.getText();
    current.noWordSep = noWordSep.getText();
    current.camelCasedWords = camelCasedWords.isSelected();
    current.folding = (String) folding.getSelectedItem();
    current.collapseFolds = collapseFolds.getText();
    current.wrap = (String) wrap.getSelectedItem();
    current.maxLineLen = (String) maxLineLen.getSelectedItem();
    current.tabSize = (String) tabSize.getSelectedItem();
    current.indentSize = (String) indentSize.getSelectedItem();
    current.noTabs = noTabs.isSelected();
    current.elasticTabstops = elasticTabstops.isSelected();
    current.autoIndent = (String) autoIndent.getSelectedItem();
    current.deepIndent = deepIndent.isSelected();
}