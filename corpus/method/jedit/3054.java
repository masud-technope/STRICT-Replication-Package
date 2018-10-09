/**
	 * Constructor that takes a name as an argument, for use by
	 * subclasses.
	 *
	 * @param name    Name of the option pane.
	 * @param caption String to use as the caption of the context menu
	 *                configuration list.
	 * @param actionContext the actionContext
	 * @since jEdit 4.5pre1
	 */
protected  AbstractContextOptionPane(String name, String caption, ActionContext actionContext) {
    super(name);
    this.actionContext = actionContext;
    this.caption = new JLabel(caption);
}