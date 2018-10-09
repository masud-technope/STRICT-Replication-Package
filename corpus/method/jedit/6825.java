public  InputMethodSupport(TextArea owner) {
    this.owner = owner;
    owner.addInputMethodListener(this);
    owner.getPainter().addExtension(TextAreaPainter.HIGHEST_LAYER, this);
}