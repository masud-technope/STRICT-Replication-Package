//}}}
//{{{ updateSelection() method
private void updateSelection() {
    ListModel model = markerList.getModel();
    int currentLine = view.getTextArea().getCaretLine();
    Buffer buffer = view.getBuffer();
    for (int i = 0; i < model.getSize(); i++) {
        Object o = model.getElementAt(i);
        if (o instanceof Marker) {
            Marker mark = (Marker) model.getElementAt(i);
            if (buffer.getLineOfOffset(mark.getPosition()) == currentLine) {
                markerList.setSelectedIndex(i);
                break;
            }
        }
    }
}