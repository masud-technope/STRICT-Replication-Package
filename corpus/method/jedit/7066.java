/**
	 * Like {@link DisplayManager#collapseFold(int)}, but
	 * also moves the caret to the first line of the fold.
	 * @param line the physical line index of the fold that we want to collapse
	 * @since jEdit 4.3pre7
	 */
public void collapseFold(int line) {
    displayManager.collapseFold(line);
}