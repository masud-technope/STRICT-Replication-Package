@EBHandler
public void handleViewUpdate(ViewUpdate viewUpdate) {
    if (viewUpdate.getView() == view && viewUpdate.getWhat() == ViewUpdate.EDIT_PANE_CHANGED) {
        if (textArea != null) {
            textArea.removeCaretListener(selectionLength);
        }
        textArea = view.getTextArea();
        if (selectionLength.visible)
            textArea.addCaretListener(selectionLength);
    }
}