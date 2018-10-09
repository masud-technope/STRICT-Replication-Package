//}}}
//{{{ lineInStructureScope() method
/**
	 * Returns if the specified line is contained in the currently
	 * matched structure's scope.
	 * @since jEdit 4.2pre3
	 */
public boolean lineInStructureScope(int line) {
    if (match == null)
        return false;
    if (match.startLine < caretLine)
        return line >= match.startLine && line <= caretLine;
    else
        return line <= match.endLine && line >= caretLine;
}