public void handleMessage(EBMessage msg) {
    if (msg instanceof PropertiesChanged) {
        showPageBreak = jEdit.getBooleanProperty("view.pageBreaks");
        pageBreakColor = jEdit.getColorProperty("view.pageBreaksColor");
        loadPageRanges();
    } else if (msg instanceof EditPaneUpdate) {
        EditPaneUpdate epu = (EditPaneUpdate) msg;
        if (EditPaneUpdate.BUFFER_CHANGED.equals(epu.getWhat())) {
            // prevent NPE in Buffer#markToken() when edit mode is not loaded
            if (epu.getEditPane().getBuffer().isLoaded()) {
                loadPageRanges();
            }
        }
    } else if (msg instanceof BufferUpdate) {
        BufferUpdate bu = (BufferUpdate) msg;
        if (BufferUpdate.SAVED.equals(bu.getWhat()) || BufferUpdate.LOADED.equals(bu.getWhat())) {
            loadPageRanges();
        }
    }
}