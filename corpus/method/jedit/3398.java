private boolean canChangeEditMode(EBMessage message) {
    if (message instanceof BufferUpdate) {
        BufferUpdate bu = (BufferUpdate) message;
        Object what = bu.getWhat();
        if ((what == BufferUpdate.CLOSED) || (what == BufferUpdate.CREATED) || (what == BufferUpdate.PROPERTIES_CHANGED)) {
            return true;
        }
    } else if (message instanceof EditPaneUpdate) {
        EditPaneUpdate ep = (EditPaneUpdate) message;
        Object what = ep.getWhat();
        if ((what == EditPaneUpdate.BUFFER_CHANGED) || (what == EditPaneUpdate.CREATED)) {
            return true;
        }
    }
    return false;
}