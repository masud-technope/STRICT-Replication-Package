/**
	 * Creates a new JEditTextArea.
	 */
public  JEditTextArea(View view) {
    super(jEdit.getPropertyManager(), view);
    enableEvents(AWTEvent.FOCUS_EVENT_MASK | AWTEvent.KEY_EVENT_MASK);
    this.view = view;
    setRightClickPopupEnabled(true);
    painter.setLineExtraSpacing(jEdit.getIntegerProperty("options.textarea.lineSpacing", 0));
    new PageBreakExtension(this);
    EditBus.addToBus(this);
}