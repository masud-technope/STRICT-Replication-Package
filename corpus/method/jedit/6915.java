//}}}
//{{{ overlaps() method
/**
	 * Returns if this selection and the specified selection overlap.
	 * @param s The other selection
	 * @since jEdit 4.1pre1
	 */
public boolean overlaps(Selection s) {
    if ((start >= s.start && start <= s.end) || (end >= s.start && end <= s.end))
        return true;
    else
        return false;
}