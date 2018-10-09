//}}}
//{{{ fontToString() method
private static String fontToString(Font font) {
    return font.getFamily() + '-' + fontStyleToString(font.getStyle()) + '-' + font.getSize();
}