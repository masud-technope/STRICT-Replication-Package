/**
	 * Creates a new font selector control.
	 * @param font The font
	 * @param antiAlias Is anti-aliasing enabled?
	 * @since jEdit 4.2pre7
	 */
public  FontSelector(Font font, boolean antiAlias) {
    setFont(font);
    this.antiAlias = antiAlias;
    updateText();
    setRequestFocusEnabled(false);
    addActionListener(new ActionHandler());
}