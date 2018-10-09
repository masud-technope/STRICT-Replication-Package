//}}}
//{{{ getMarkPosition() method
/**
	 * @deprecated Do not use.
	 */
@Deprecated
public final int getMarkPosition() {
    Selection s = getSelectionAtOffset(caret);
    if (s == null)
        return caret;
    if (s.start == caret)
        return s.end;
    else if (s.end == caret)
        return s.start;
    else
        return caret;
}