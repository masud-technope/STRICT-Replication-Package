/**
	 * Creates a new view update message.
	 * @param view The view
	 * @param what What happened
	 */
public  ViewUpdate(View view, Object what) {
    super(view);
    if (what == null)
        throw new NullPointerException("What must be non-null");
    this.what = what;
}