//}}}
//{{{ invalidateStructureMatch() method
void invalidateStructureMatch() {
    if (match != null)
        invalidateLineRange(match.startLine, match.endLine);
}