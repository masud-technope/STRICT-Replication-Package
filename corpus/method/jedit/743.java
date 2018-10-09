//{{{ FileCellRenderer constructor
public  FileCellRenderer() {
    plainFont = UIManager.getFont("Tree.font");
    if (plainFont == null)
        plainFont = jEdit.getFontProperty("metal.secondary.font");
    boldFont = plainFont.deriveFont(Font.BOLD);
}