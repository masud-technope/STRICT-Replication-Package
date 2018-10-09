//{{{ ResultCellRenderer constructor
 ResultCellRenderer() {
    plainFont = UIManager.getFont("Tree.font");
    if (plainFont == null)
        plainFont = jEdit.getFontProperty("metal.secondary.font");
    boldFont = new Font(plainFont.getName(), Font.BOLD, plainFont.getSize());
//}}}
}