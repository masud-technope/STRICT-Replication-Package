/**
	 * Creates a new painter. Do not create instances of this class
	 * directly.
	 */
 TextAreaPainter(TextArea textArea) {
    enableEvents(AWTEvent.FOCUS_EVENT_MASK | AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK);
    this.textArea = textArea;
    antiAlias = new AntiAlias(0);
    extensionMgr = new ExtensionManager();
    eolMarkerChar = "·";
    setAutoscrolls(true);
    setOpaque(true);
    setRequestFocusEnabled(false);
    setDoubleBuffered(false);
    setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
    fontRenderContext = new FontRenderContext(null, false, false);
    addExtension(LINE_BACKGROUND_LAYER, new PaintLineBackground());
    addExtension(SELECTION_LAYER, new PaintSelection());
    addExtension(WRAP_GUIDE_LAYER, new PaintWrapGuide());
    addExtension(BRACKET_HIGHLIGHT_LAYER, new StructureMatcher.Highlight(textArea));
    addExtension(TEXT_LAYER, new PaintText());
    addExtension(TEXT_LAYER, new PaintSelectionText());
    caretExtension = new PaintCaret();
    extraLineSpacing = 0;
}