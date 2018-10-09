//}}}
//{{{ toggleLocked() method
/**
	 * Toggles locked state of the buffer.
	 * @param view We show a message in the view's status bar
	 */
public void toggleLocked(View view) {
    setLocked(!isLocked());
    view.getStatus().setMessageAndClear(jEdit.getProperty("view.status.locked-changed", new Integer[] { isLocked() ? 1 : 0 }));
    EditBus.send(new PropertiesChanged(Buffer.this));
}