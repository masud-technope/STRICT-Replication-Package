/**
		 * Sets the clipboard contents.
		 */
@Override
public void setValue(String value) {
    Transferable selection = new StringSelection(value);
    clipboard.setContents(selection, null);
}