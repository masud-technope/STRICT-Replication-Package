 SelectionLengthWidget(View view) {
    this.view = view;
    textArea = view.getTextArea();
    selectionLength = new SelectionLength();
    selectionLength.setForeground(jEdit.getColorProperty("view.status.foreground"));
    selectionLength.setBackground(jEdit.getColorProperty("view.status.background"));
    EditBus.addToBus(this);
}