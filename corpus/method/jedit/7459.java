private EditPane createEditPane(@Nullable BufferSet bufferSetSource, @Nonnull Buffer buffer) {
    EditPane editPane = new EditPane(this, bufferSetSource, buffer);
    JEditTextArea textArea = editPane.getTextArea();
    textArea.addFocusListener(new FocusHandler());
    textArea.addCaretListener(new CaretHandler());
    textArea.addScrollListener(new ScrollHandler());
    EditBus.send(new EditPaneUpdate(editPane, EditPaneUpdate.CREATED));
    return editPane;
}