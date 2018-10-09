public  PaneNameRenderer() {
    paneFont = UIManager.getFont("Tree.font");
    if (paneFont == null)
        paneFont = jEdit.getFontProperty("metal.secondary.font");
    groupFont = paneFont.deriveFont(Font.BOLD);
}