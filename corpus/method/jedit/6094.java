/**
	 * Inserts the contents of the specified register into the text area.
	 * @param textArea The text area
	 * @param register The register
	 * @param vertical Vertical (columnar) paste
	 * @param preferredDataFlavor the preferred dataflavor. If not available
	 * <tt>DataFlavor.stringFlavor</tt> will be used
	 * @since jEdit 4.4pre1
	 */
public static void paste(TextArea textArea, char register, boolean vertical, DataFlavor preferredDataFlavor) {
    if (JEditDataFlavor.jEditRichTextDataFlavor.equals(preferredDataFlavor)) {
        paste(textArea, register, vertical);
        return;
    }
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
    String selection = null;
    if (transferable.isDataFlavorSupported(preferredDataFlavor)) {
        selection = getTextFromTransferable(transferable, preferredDataFlavor);
    } else if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
        selection = getTextFromTransferable(transferable, DataFlavor.stringFlavor);
    }
    if (selection == null) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    JEditBuffer buffer = textArea.getBuffer();
    /*
		 Commented because it must not use jEdit class.
		 Need to rewrite a property manager that is independant
		String mime = preferredDataFlavor.getMimeType();
		int i = mime.indexOf(';');
		if (i != -1)
		{
			mime = mime.substring(0,i);
		}
		String mode = jEdit.getProperty("mime2mode."+mime);
		if (mode != null)
		{
			Mode _mode = ModeProvider.instance.getMode(mode);
			if (_mode != null)
			{
				applyMode(_mode, buffer);
			}
		}     */
    _paste(textArea, vertical, selection, buffer);
}