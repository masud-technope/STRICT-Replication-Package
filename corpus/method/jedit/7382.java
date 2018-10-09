//}}}
//{{{ setStructureHighlightEnabled() method
/**
	 * Enables or disables structure highlighting.
	 * @param structureHighlight True if structure highlighting should be
	 * enabled, false otherwise
	 * @since jEdit 4.2pre3
	 */
public final void setStructureHighlightEnabled(boolean structureHighlight) {
    this.structureHighlight = structureHighlight;
    textArea.invalidateStructureMatch();
}