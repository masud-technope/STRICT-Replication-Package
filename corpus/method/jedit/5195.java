/**
	 * Creates a new edit pane update message.
	 * @param editPane The edit pane
	 * @param what What happened
	 */
public  EditPaneUpdate(EditPane editPane, Object what) {
    super(editPane);
    if (what == null)
        throw new NullPointerException("What must be non-null");
    this.what = what;
}