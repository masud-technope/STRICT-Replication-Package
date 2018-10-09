private void loadInvalidStyle() {
    Font font = getFont();
    String family = font.getFamily();
    int size = font.getSize();
    invalidStyle = SyntaxUtilities.parseStyle(jEdit.getProperty("view.style.invalid"), family, size, true);
    defaultForeground = getForeground();
    defaultBackground = getBackground();
}