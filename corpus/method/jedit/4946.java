/**
	 * Creates a new action set.
	 * @since jEdit 4.3pre13
	 */
protected  JEditActionSet() {
    actions = new HashMap<String, JEditAbstractEditAction>();
    loaded = true;
}