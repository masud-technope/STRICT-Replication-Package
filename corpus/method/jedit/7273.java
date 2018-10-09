//}}}
//{{{ isStructureHighlightVisible() method
/**
	 * Returns true if the structure highlight is visible, false otherwise.
	 * @since jEdit 4.2pre3
	 */
final boolean isStructureHighlightVisible() {
    return match != null && hasFocus() && displayManager.isLineVisible(match.startLine) && displayManager.isLineVisible(match.endLine);
}