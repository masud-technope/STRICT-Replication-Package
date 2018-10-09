/**
	 * Constructs a new VFSFileChooserDialog.
	 * This version can specify a dialog as the parent instead
	 * of the view.
	 * @since jEdit 4.3pre10
	 */
public  VFSFileChooserDialog(Dialog parent, View view, String path, int mode, boolean multipleSelection, boolean autoshow) {
    super(parent, getTitle(mode), true);
    setFocusTraversalPolicy(new LayoutFocusTraversalPolicy());
    _init(view, path, mode, multipleSelection, autoshow);
}