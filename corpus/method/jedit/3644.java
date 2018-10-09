//}}}
//{{{ processMouseEvent() method
protected void processMouseEvent(MouseEvent evt) {
    if (!isEnabled())
        return;
    switch(evt.getID()) {
        case MouseEvent.MOUSE_PRESSED:
            if (GenericGUIUtilities.isPopupTrigger(evt))
                controller.showPopupMenu(evt.isShiftDown());
            else
                super.processMouseEvent(evt);
            break;
        default:
            super.processMouseEvent(evt);
            break;
    }
}