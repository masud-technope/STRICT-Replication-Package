/**
	 * Instantiate a TextArea.
	 */
public  JEditEmbeddedTextArea() {
    super(jEdit.getPropertyManager(), null);
    initInputHandler();
    EditPane.initPainter(getPainter());
    JEditBuffer buffer = new JEditBuffer();
    buffer.setMode(ModeProvider.instance.getMode("text"));
    setBuffer(buffer);
}