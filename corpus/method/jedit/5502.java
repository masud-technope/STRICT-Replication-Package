//{{{ StyleTableModel constructor
 StyleTableModel() {
    styleChoices = new Vector<StyleChoice>(Token.ID_COUNT + 4);
    // start at 1 not 0 to skip Token.NULL
    for (int i = 1; i < Token.ID_COUNT; i++) {
        String tokenName = Token.tokenToString((byte) i);
        addStyleChoice(tokenName, "view.style." + tokenName.toLowerCase());
    }
    addStyleChoice(jEdit.getProperty("options.syntax.foldLine.1"), "view.style.foldLine.1");
    addStyleChoice(jEdit.getProperty("options.syntax.foldLine.2"), "view.style.foldLine.2");
    addStyleChoice(jEdit.getProperty("options.syntax.foldLine.3"), "view.style.foldLine.3");
    addStyleChoice(jEdit.getProperty("options.syntax.foldLine.0"), "view.style.foldLine.0");
    Collections.sort(styleChoices, new StandardUtilities.StringCompare<StyleChoice>(true));
//}}}
}