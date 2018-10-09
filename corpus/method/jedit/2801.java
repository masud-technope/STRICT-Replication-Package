//}}}
//{{{ stringToSelection() method
private static Selection[] stringToSelection(String s) {
    if (s == null)
        return null;
    List<Selection> selection = new ArrayList<Selection>();
    StringTokenizer st = new StringTokenizer(s);
    while (st.hasMoreTokens()) {
        String type = st.nextToken();
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        if (end < start) {
            // jEdit bug tracker.
            continue;
        }
        Selection sel;
        if ("range".equals(type))
            sel = new Selection.Range(start, end);
        else
            //if(type.equals("rect"))
            sel = new Selection.Rect(start, end);
        selection.add(sel);
    }
    Selection[] returnValue = new Selection[selection.size()];
    returnValue = selection.toArray(returnValue);
    return returnValue;
}