//{{{ processMouseEvent() method
protected void processMouseEvent(MouseEvent evt) {
    switch(evt.getID()) {
        /* case MouseEvent.MOUSE_ENTERED:
				toolTipInitialDelay = ttm.getInitialDelay();
				toolTipReshowDelay = ttm.getReshowDelay();
				ttm.setInitialDelay(200);
				ttm.setReshowDelay(0);
				super.processMouseEvent(evt);
				break;
			case MouseEvent.MOUSE_EXITED:
				ttm.setInitialDelay(toolTipInitialDelay);
				ttm.setReshowDelay(toolTipReshowDelay);
				super.processMouseEvent(evt);
				break; */
        case MouseEvent.MOUSE_CLICKED:
            TreePath path = getPathForLocation(evt.getX(), evt.getY());
            expandOrGotoPath(path);
            super.processMouseEvent(evt);
            break;
        default:
            super.processMouseEvent(evt);
            break;
    }
//}}}
}