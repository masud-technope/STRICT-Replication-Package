//{{{ getIconHeight() method
public int getIconHeight() {
    return (int) (rotate == RotatedTextIcon.CW || rotate == RotatedTextIcon.CCW ? width : height);
//}}}
}