// add an Integer or Float document filter as appropriate
private void addFilter() {
    if (integerOnly)
        ((AbstractDocument) this.getDocument()).setDocumentFilter(new IntegerDocumentFilter());
    else
        ((AbstractDocument) this.getDocument()).setDocumentFilter(new FloatDocumentFilter());
    // apply the filter to the current value
    try {
        String text = getText();
        ((AbstractDocument) getDocument()).getDocumentFilter().replace(null, 0, text.length(), text, null);
    }// NOPMD
     catch (Exception e) {
    }
}