 Renderer() {
    entryFont = UIManager.getFont("Tree.font");
    if (entryFont == null)
        entryFont = jEdit.getFontProperty("metal.secondary.font");
    groupFont = entryFont.deriveFont(Font.BOLD);
}