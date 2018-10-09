/**
	 * Constructor that takes a name as an argument, for use by
	 * subclasses.
	 *
	 * @param name    Name of the option pane.
	 * @param caption String to use as the caption of the context menu
	 *                configuration list.
	 * @since jEdit 4.3pre13
	 */
protected  AbstractContextOptionPane(String name, String caption) {
    this(name, caption, jEdit.getActionContext());
}