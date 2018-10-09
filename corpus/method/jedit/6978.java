//}}}
//{{{ initTextArea() method
/**
	 * Initializes the text area by re-reading the properties from the property manager passed to the
	 * constructor.
	 */
private void initTextArea() {
    initPainter();
    initGutter();
    setCaretBlinkEnabled(getBooleanProperty("view.caretBlink"));
    setElectricScroll(getIntegerProperty("view.electricBorders", 0));
    if (buffer == null)
        return;
    String property = propertyManager.getProperty("buffer.undoCount");
    int undoCount = 100;
    if (property != null) {
        try {
            undoCount = Integer.parseInt(property);
        } catch (NumberFormatException e) {
        }
    }
    buffer.setUndoLimit(undoCount);
}