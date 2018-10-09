/**
	 * Constructor for the ShortcutPrefixActiveEvent object
	 *
	 * @param bindings Description of the Parameter
	 * @param active   Description of the Parameter
	 */
public  ShortcutPrefixActiveEvent(Hashtable bindings, boolean active) {
    super(new Object());
    this.bindings = bindings;
    this.active = active;
}