@Override
protected void processFocusEvent(FocusEvent e) {
    // to happen, so ignore lost focus events.
    if (e.getID() != FocusEvent.FOCUS_LOST)
        super.processFocusEvent(e);
    else {
        setCaretPosition(0);
        getCaret().setVisible(false);
    }
}