//{{{ getToolTipLocation() method
/* public final Point getToolTipLocation(MouseEvent evt)
		{
			TreePath path = getPathForLocation(evt.getX(), evt.getY());
			if(path != null)
			{
				Rectangle cellRect = getPathBounds(path);
				if(cellRect != null && !cellRectIsVisible(cellRect))
				{
					return new Point(cellRect.x + 14, cellRect.y);
				}
			}
			return null;
		} */
//}}}
//{{{ processKeyEvent() method
public void processKeyEvent(KeyEvent evt) {
    if ((KeyEvent.KEY_PRESSED == evt.getID()) && (KeyEvent.VK_ENTER == evt.getKeyCode())) {
        TreePath path = getSelectionPath();
        expandOrGotoPath(path);
        evt.consume();
    } else {
        super.processKeyEvent(evt);
    }
//}}}
}