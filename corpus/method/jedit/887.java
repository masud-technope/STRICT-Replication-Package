//}}}
//{{{ scrollRectToVisible() method
@Override
public void scrollRectToVisible(Rectangle rect) {
    // avoid scrolling to the right
    rect.width = 0;
    super.scrollRectToVisible(rect);
}