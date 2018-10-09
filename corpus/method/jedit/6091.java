//{{{ copy() method
/**
	 * Copies the text selected in the text area into the specified register.
	 * This will replace the existing contents of the designated register.
	 *
	 * @param textArea The text area
	 * @param register The register
	 * @since jEdit 2.7pre2
	 */
public static void copy(TextArea textArea, char register) {
    String selection = textArea.getSelectedText();
    if (selection == null)
        return;
    Transferable transferable = TransferHandler.getInstance().getTransferable(textArea, selection);
    setRegister(register, transferable);
    HistoryModel.getModel("clipboard").addItem(selection);
}