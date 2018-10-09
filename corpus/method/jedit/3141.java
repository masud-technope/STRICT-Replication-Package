//}}}
//{{{ getColor()
public Color getColor() {
    Color selectedColor = colorChooser.getColor();
    return selectedColor == null ? initialColor : selectedColor;
}