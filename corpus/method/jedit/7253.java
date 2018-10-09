//}}}
//{{{ setMouseHandler() method
public void setMouseHandler(MouseInputAdapter mouseInputAdapter) {
    mouseHandler = mouseInputAdapter;
    painter.addMouseListener(mouseHandler);
    painter.addMouseMotionListener(mouseHandler);
}