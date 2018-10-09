//{{{ load() method
void load() {
    if (loaded)
        return;
    loaded = true;
    if (mode != null) {
        mode.loadIfNecessary();
        useDefaults = !jEdit.getBooleanProperty("mode." + mode.getName() + ".customSettings");
        filenameGlob = (String) mode.getProperty("filenameGlob");
        firstlineGlob = (String) mode.getProperty("firstlineGlob");
        noWordSep = (String) mode.getProperty("noWordSep");
        camelCasedWords = mode.getBooleanProperty("camelCasedWords");
        folding = mode.getProperty("folding").toString();
        collapseFolds = mode.getProperty("collapseFolds").toString();
        wrap = mode.getProperty("wrap").toString();
        maxLineLen = mode.getProperty("maxLineLen").toString();
        tabSize = mode.getProperty("tabSize").toString();
        indentSize = mode.getProperty("indentSize").toString();
        noTabs = mode.getBooleanProperty("noTabs");
        elasticTabstops = mode.getBooleanProperty("elasticTabstops");
        autoIndent = mode.getProperty("autoIndent").toString();
        deepIndent = mode.getBooleanProperty("deepIndent");
        isUserMode = mode.isUserMode();
    } else {
        noWordSep = jEdit.getProperty("buffer.noWordSep");
        camelCasedWords = jEdit.getBooleanProperty("buffer.camelCasedWords");
        folding = jEdit.getProperty("buffer.folding");
        collapseFolds = jEdit.getProperty("buffer.collapseFolds");
        wrap = jEdit.getProperty("buffer.wrap");
        maxLineLen = jEdit.getProperty("buffer.maxLineLen");
        tabSize = jEdit.getProperty("buffer.tabSize");
        indentSize = jEdit.getProperty("buffer.indentSize");
        noTabs = jEdit.getBooleanProperty("buffer.noTabs");
        elasticTabstops = jEdit.getBooleanProperty("buffer.elasticTabstops");
        autoIndent = jEdit.getProperty("buffer.autoIndent");
        deepIndent = jEdit.getBooleanProperty("buffer.deepIndent");
    }
//}}}
}