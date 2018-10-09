/**
	 * Saves jEdit's context menu configuration.
	 *
	 * @since jEdit 4.3pre13
	 */
@Override
protected void saveContextMenu(String menu) {
    jEdit.setProperty("view.context", menu);
    jEdit.setBooleanProperty("options.context.includeOptionsLink", includeOptionsLink.isSelected());
}