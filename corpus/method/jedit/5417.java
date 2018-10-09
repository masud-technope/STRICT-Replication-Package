//{{{ save() method
void save() {
    // any settings
    if (!edited)
        return;
    String prefix;
    if (mode != null) {
        prefix = "mode." + mode.getName() + '.';
        jEdit.setBooleanProperty(prefix + "customSettings", !useDefaults);
        // need to call Mode.init() if the file name or first line
        // globs change
        String oldFilenameGlob = (String) mode.getProperty("filenameGlob");
        String oldFirstlineGlob = (String) mode.getProperty("firstlineGlob");
        if (useDefaults) {
            jEdit.resetProperty(prefix + "filenameGlob");
            jEdit.resetProperty(prefix + "firstlineGlob");
            jEdit.resetProperty(prefix + "noWordSep");
            jEdit.resetProperty(prefix + "camelCasedWords");
            jEdit.resetProperty(prefix + "folding");
            jEdit.resetProperty(prefix + "collapseFolds");
            jEdit.resetProperty(prefix + "wrap");
            jEdit.resetProperty(prefix + "maxLineLen");
            jEdit.resetProperty(prefix + "tabSize");
            jEdit.resetProperty(prefix + "indentSize");
            jEdit.resetProperty(prefix + "noTabs");
            jEdit.resetProperty(prefix + "elasticTabstops");
            jEdit.resetProperty(prefix + "autoIndent");
            jEdit.resetProperty(prefix + "deepIndent");
            if (!(Objects.equals(oldFilenameGlob, mode.getProperty("filenameGlob")) && Objects.equals(oldFirstlineGlob, mode.getProperty("firstlineGlob")))) {
                mode.init();
            }
            return;
        } else {
            jEdit.setProperty(prefix + "filenameGlob", filenameGlob);
            jEdit.setProperty(prefix + "firstlineGlob", firstlineGlob);
            if (!(Objects.equals(oldFilenameGlob, filenameGlob) && Objects.equals(oldFirstlineGlob, firstlineGlob))) {
                mode.init();
            }
        }
    } else {
        prefix = "buffer.";
    }
    jEdit.setProperty(prefix + "noWordSep", noWordSep);
    jEdit.setBooleanProperty(prefix + "camelCasedWords", camelCasedWords);
    jEdit.setProperty(prefix + "folding", folding);
    jEdit.setProperty(prefix + "collapseFolds", collapseFolds);
    jEdit.setProperty(prefix + "wrap", wrap);
    jEdit.setProperty(prefix + "maxLineLen", maxLineLen);
    jEdit.setProperty(prefix + "tabSize", tabSize);
    jEdit.setProperty(prefix + "indentSize", indentSize);
    jEdit.setProperty(prefix + "autoIndent", autoIndent);
    jEdit.setBooleanProperty(prefix + "noTabs", noTabs);
    jEdit.setBooleanProperty(prefix + "elasticTabstops", elasticTabstops);
    jEdit.setBooleanProperty(prefix + "deepIndent", deepIndent);
//}}}
}