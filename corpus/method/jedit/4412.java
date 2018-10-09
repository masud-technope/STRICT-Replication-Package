@Override
public void mousePressed(MouseEvent me) {
    if (me.isPopupTrigger()) {
        handlePopupTrigger(me);
    }
}