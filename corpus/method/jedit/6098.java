/**
	 * Appends the text selected in the  text area to the specified register.
	 * @param textArea The text area
	 * @param register The register
	 * @param separator The text to insert between the old and new text
	 * @param cut Should the current selection be removed?
	 * @since jEdit 3.2pre1
	 */
public static void append(TextArea textArea, char register, String separator, boolean cut) {
    if (cut && !textArea.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    String selection = textArea.getSelectedText();
    if (selection == null)
        return;
    Register reg = getRegister(register);
    if (reg != null) {
        Transferable transferable = reg.getTransferable();
        if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                String registerContents = (String) transferable.getTransferData(DataFlavor.stringFlavor);
                if (registerContents != null) {
                    if (registerContents.endsWith(separator))
                        selection = registerContents + selection;
                    else
                        selection = registerContents + separator + selection;
                }
            } catch (UnsupportedFlavorException e) {
            } catch (IOException e) {
                Log.log(Log.ERROR, Registers.class, e);
            }
        }
    }
    Transferable transferable = TransferHandler.getInstance().getTransferable(textArea, selection);
    setRegister(register, transferable);
    HistoryModel.getModel("clipboard").addItem(selection);
    if (cut)
        textArea.setSelectedText("");
}