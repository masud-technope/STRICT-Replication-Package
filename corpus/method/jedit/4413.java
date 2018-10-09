@Override
public void mouseReleased(MouseEvent me) {
    if (me.isPopupTrigger()) {
        handlePopupTrigger(me);
    }
}