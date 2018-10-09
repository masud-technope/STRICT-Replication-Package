//}}}
//{{{ updateEnabled() method
private void updateEnabled() {
    boolean enabled;
    if (current == global) {
        enabled = true;
        useDefaults.setEnabled(false);
        filenameGlob.setEnabled(false);
        firstlineGlob.setEnabled(false);
    } else {
        enabled = !modeProps[mode.getSelectedIndex() - 1].useDefaults;
        useDefaults.setEnabled(true);
        filenameGlob.setEnabled(enabled);
        firstlineGlob.setEnabled(enabled);
    }
    noWordSep.setEnabled(enabled);
    camelCasedWords.setEnabled(enabled);
    folding.setEnabled(enabled);
    collapseFolds.setEnabled(enabled);
    wrap.setEnabled(enabled);
    maxLineLen.setEnabled(enabled);
    tabSize.setEnabled(enabled);
    indentSize.setEnabled(enabled);
    noTabs.setEnabled(enabled);
    elasticTabstops.setEnabled(enabled);
    autoIndent.setEnabled(enabled);
    deepIndent.setEnabled(enabled);
}