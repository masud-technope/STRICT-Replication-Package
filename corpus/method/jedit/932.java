/**
	 * Constructs a new VFSFileChooserDialog. If <code>authoshow</code>
	 * is true, the dialog will be show automatically and the call
	 * will only return after the user disposes of the dialog.
	 *
	 * @since jEdit 4.3pre7
	 */
public  VFSFileChooserDialog(View view, String path, int mode, boolean multipleSelection, boolean autoshow) {
    super(view, getTitle(mode), true);
    setFocusTraversalPolicy(new LayoutFocusTraversalPolicy());
    _init(view, path, mode, multipleSelection, autoshow);
}