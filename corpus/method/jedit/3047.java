/**
	 * Returns the context menu to be edited. The default implementation
	 * returns jEdit's context menu. Subclasses overriding this method
	 * should also override {@link #saveContextMenu(String menu) saveContextMenu}.
	 *
	 * @since jEdit 4.3pre13
	 */
protected abstract String getContextMenu();