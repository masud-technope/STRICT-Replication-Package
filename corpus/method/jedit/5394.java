//}}}
//{{{ getSelectionAreaBgColor() method
public static Color getSelectionAreaBackground() {
    String color = jEdit.getProperty(SELECTION_AREA_BGCOLOR_PROPERTY);
    if (color == null)
        return jEdit.getColorProperty("view.gutter.bgColor");
    return SyntaxUtilities.parseColor(color, Color.black);
}