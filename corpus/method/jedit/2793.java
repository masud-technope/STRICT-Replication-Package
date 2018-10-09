//}}}
//{{{ selectionToString() method
private static String selectionToString(Selection[] s) {
    if (s == null)
        return null;
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < s.length; i++) {
        if (i != 0)
            buf.append(' ');
        Selection sel = s[i];
        if (sel instanceof Selection.Range)
            buf.append("range ");
        else
            //if(sel instanceof Selection.Rect)
            buf.append("rect ");
        buf.append(sel.getStart());
        buf.append(' ');
        buf.append(sel.getEnd());
    }
    return buf.toString();
}