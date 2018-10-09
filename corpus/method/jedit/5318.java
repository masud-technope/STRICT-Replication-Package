/**
	 * Returns jEdit's context menu configuration.
	 *
	 * @since jEdit 4.3pre13
	 */
@Override
protected String getContextMenu() {
    return jEdit.getProperty("browser.custom.context");
}