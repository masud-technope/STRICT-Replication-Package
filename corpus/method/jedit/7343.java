//}}}
//{{{ addNotify() method
@Override
public void addNotify() {
    super.addNotify();
    hiddenCursor = getToolkit().createCustomCursor(getGraphicsConfiguration().createCompatibleImage(16, 16, Transparency.BITMASK), new Point(0, 0), "Hidden");
}