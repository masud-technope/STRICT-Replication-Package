/**
	 * @param frame - the parent frame for dialogs created
	 * @param name the name of an option pane - it must have a .title and .code
	 *  		property defined in order to instantiate.
	 * @param pane the initial pane to show when this is created.
	 */
protected  OptionsDialog(Frame frame, String name, String pane) {
    super(frame, jEdit.getProperty(name + ".title"), true);
    init(name, pane);
}