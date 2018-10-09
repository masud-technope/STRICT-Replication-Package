//}}}
//{{{ fontStyleToString() method
private static String fontStyleToString(int style) {
    if (style == 0)
        return "PLAIN";
    else if (style == Font.BOLD)
        return "BOLD";
    else if (style == Font.ITALIC)
        return "ITALIC";
    else if (style == (Font.BOLD | Font.ITALIC))
        return "BOLDITALIC";
    else
        throw new RuntimeException("Invalid style: " + style);
}