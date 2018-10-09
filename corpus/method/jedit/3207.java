/**
	 * Creates a new input handler with no key bindings defined.
	 * @param view The view
	 * @param bindings An explicitly-specified set of key bindings,
	 * must not be null.
	 * @since jEdit 4.3pre1
	 */
public  DefaultInputHandler(View view, Hashtable bindings) {
    super(view);
    if (bindings == null)
        throw new NullPointerException();
    this.bindings = this.currentBindings = bindings;
}