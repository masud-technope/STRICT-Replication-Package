/**
	 * Creates a new input handler with the same set of key bindings
	 * as the one specified. Note that both input handlers share
	 * a pointer to exactly the same key binding table; so adding
	 * a key binding in one will also add it to the other.
	 * @param copy The input handler to copy key bindings from
	 * @param view The view
	 */
public  DefaultInputHandler(View view, DefaultInputHandler copy) {
    this(view, copy.bindings);
}