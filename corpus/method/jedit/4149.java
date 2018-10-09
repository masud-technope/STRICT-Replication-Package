public  StyleEditor(JFrame parent, SyntaxStyle style, String styleName) {
    super(parent, jEdit.getProperty("style-editor.title"), true);
    initialize(parent, style, styleName);
}