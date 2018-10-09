//}}}
//{{{ paintChildren() method
public void paintChildren(Graphics g) {
    super.paintChildren(g);
    if (resizeRect != null) {
        g.setColor(Color.darkGray);
        g.fillRect(resizeRect.x, resizeRect.y, resizeRect.width, resizeRect.height);
    }
}