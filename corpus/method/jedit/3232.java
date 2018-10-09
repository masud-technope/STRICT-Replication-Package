//{{{ mousePressed() method
public void mousePressed(MouseEvent evt) {
    if (canDrag) {
        continuousLayout = UIManager.getBoolean("SplitPane.continuousLayout");
        wm.setResizePos(panel.getDimension(), panel);
        dragStart = evt.getPoint();
    }
//}}}
}