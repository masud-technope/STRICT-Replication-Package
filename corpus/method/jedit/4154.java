//{{{ StyleEditor constructor
public  StyleEditor(JDialog parent, SyntaxStyle style, String styleName) {
    super(parent, jEdit.getProperty("style-editor.title"), true);
    initialize(parent, style, styleName);
}