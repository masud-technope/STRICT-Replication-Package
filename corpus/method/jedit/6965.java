//}}}
//{{{ addToSelection() method
void addToSelection(Selection addMe) {
    if (addMe.start > addMe.end) {
        throw new IllegalArgumentException(addMe.start + " > " + addMe.end);
    } else if (addMe.start == addMe.end) {
        if (addMe instanceof Selection.Range)
            return;
        else if (addMe instanceof Selection.Rect) {
            if (((Selection.Rect) addMe).extraEndVirt == 0)
                return;
        }
    }
    Iterator<Selection> iter = selection.iterator();
    while (iter.hasNext()) {
        // try and merge existing selections one by
        // one with the new selection
        Selection s = iter.next();
        if (s.overlaps(addMe)) {
            addMe.start = Math.min(s.start, addMe.start);
            addMe.end = Math.max(s.end, addMe.end);
            iter.remove();
        }
    }
    addMe.startLine = textArea.getLineOfOffset(addMe.start);
    addMe.endLine = textArea.getLineOfOffset(addMe.end);
    boolean added = false;
    for (int i = 0; i < selection.size(); i++) {
        Selection s = selection.get(i);
        if (addMe.start < s.start) {
            selection.add(i, addMe);
            added = true;
            break;
        }
    }
    if (!added)
        selection.add(addMe);
    textArea.invalidateLineRange(addMe.startLine, addMe.endLine);
}