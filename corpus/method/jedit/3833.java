//{{{ getIconWidth() method
public int getIconWidth() {
    return (int) (rotate == RotatedTextIcon.CW || rotate == RotatedTextIcon.CCW ? height : width);
//}}}
}