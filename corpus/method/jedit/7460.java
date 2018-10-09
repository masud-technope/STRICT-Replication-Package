//}}}
//{{{ setEditPane() method
private void setEditPane(EditPane editPane) {
    this.editPane = editPane;
    status.updateCaretStatus();
    status.updateBufferStatus();
    status.updateMiscStatus();
    // repaint the gutter so that the border color
    // reflects the focus state
    updateGutterBorders();
    EditBus.send(new ViewUpdate(this, ViewUpdate.EDIT_PANE_CHANGED));
}