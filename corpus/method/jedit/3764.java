//}}}
//{{{ goToSelectedMarker() method
private void goToSelectedMarker() {
    Object value = markerList.getSelectedValue();
    if (!(value instanceof Marker))
        return;
    Marker mark = (Marker) value;
    view.getTextArea().setCaretPosition(mark.getPosition());
    view.toFront();
    view.requestFocus();
    view.getTextArea().requestFocus();
}