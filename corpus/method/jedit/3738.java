//}}}
//{{{ setBounds() method
@Override
public void setBounds(int x, int y, int width, int height) {
    super.setBounds(x, y, width, height);
    scrollLaterIfRequired();
}