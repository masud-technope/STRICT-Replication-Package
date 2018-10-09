/**
	 *
	 * @param ta the TextArea where the context menu was requested.
	 * 	   Use this to determine the location of the caret, or the edit mode of the buffer, etc.
	 * @param evt a mouseEvent that triggered this menu request, or null
	 * @return an array of menu items
	 *         or null if there are no appropriate actions to be added at this time
	 */
public abstract JMenuItem[] createMenu(JEditTextArea ta, MouseEvent evt);