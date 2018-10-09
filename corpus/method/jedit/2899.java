public Transferable getTransferable(TextArea textArea, String text) {
    return new RichTextTransferable(text, textArea.getBuffer().getMode().getName());
}