/**
	 * Inserts the contents of the specified register into the text area.
	 * @param textArea The text area
	 * @param register The register
	 * @param vertical Vertical (columnar) paste
	 * @since jEdit 4.1pre1
	 */
public static void paste(TextArea textArea, char register, boolean vertical) {
    if (!textArea.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    Register reg = getRegister(register);
    if (reg == null) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    Transferable transferable = reg.getTransferable();
    Mode mode = null;
    String selection = null;
    if (transferable.isDataFlavorSupported(JEditDataFlavor.jEditRichTextDataFlavor)) {
        try {
            JEditRichText data = (JEditRichText) transferable.getTransferData(JEditDataFlavor.jEditRichTextDataFlavor);
            mode = data.getMode();
            selection = data.getText();
        } catch (UnsupportedFlavorException e) {
            Log.log(Log.ERROR, Registers.class, e);
        } catch (IOException e) {
            Log.log(Log.ERROR, Registers.class, e);
        }
    } else if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
        selection = getTextFromTransferable(transferable, DataFlavor.stringFlavor);
    }
    if (selection == null) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    JEditBuffer buffer = textArea.getBuffer();
    applyMode(mode, buffer);
    _paste(textArea, vertical, selection, buffer);
}