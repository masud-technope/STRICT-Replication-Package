//}}}
//{{{ updateText() method
private void updateText() {
    Font font = getFont();
    String styleString;
    switch(font.getStyle()) {
        case Font.PLAIN:
            styleString = jEdit.getProperty("font-selector.plain");
            break;
        case Font.BOLD:
            styleString = jEdit.getProperty("font-selector.bold");
            break;
        case Font.ITALIC:
            styleString = jEdit.getProperty("font-selector.italic");
            break;
        case Font.BOLD | Font.ITALIC:
            styleString = jEdit.getProperty("font-selector.bolditalic");
            break;
        default:
            styleString = "UNKNOWN!!!???";
            break;
    }
    setText(font.getName() + ' ' + font.getSize() + ' ' + styleString);
}