/**
	 * Returns the keymap with that name.
	 * @param name the keymap name
	 * @return the user keymap of that name, if it exists, or the system keymap if it doesn't.
	 * If none exists <code>null</code> is returned
	 */
Keymap getKeymap(String name);