//{{{ getToolTipLocation() method
@Override
public Point getToolTipLocation(MouseEvent event) {
    return new Point(event.getX(), -20);
//}}}
}