public  PageBreakExtension(JEditTextArea textArea) {
    this.textArea = textArea;
    textArea.getPainter().addExtension(TextAreaPainter.WRAP_GUIDE_LAYER, this);
    showPageBreak = jEdit.getBooleanProperty("view.pageBreaks", false);
    pageBreakColor = jEdit.getColorProperty("view.pageBreaksColor");
    EditBus.addToBus(this);
}