//}}}
//{{{ cut() method
/**
	 * Copies the text selected in the text area into the specified
	 * register, and then removes it from the buffer.
	 *
	 * @param textArea The text area
	 * @param register The register
	 * @since jEdit 2.7pre2
	 */
public static void cut(TextArea textArea, char register) {
    if (textArea.isEditable()) {
        String selection = textArea.getSelectedText();
        if (selection == null)
            return;
        Transferable transferable = TransferHandler.getInstance().getTransferable(textArea, selection);
        setRegister(register, transferable);
        HistoryModel.getModel("clipboard").addItem(selection);
        textArea.setSelectedText("");
    } else
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
}