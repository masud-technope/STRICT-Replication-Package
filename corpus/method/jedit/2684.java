//}}}
//{{{ addEdit() method
private void addEdit(Edit edit) {
    if (undosFirst == null)
        undosFirst = undosLast = edit;
    else {
        undosLast.next = edit;
        edit.prev = undosLast;
        undosLast = edit;
    }
    redosFirst = null;
    undoCount++;
    while (undoCount > limit) {
        undoCount--;
        if (undosFirst == undosLast)
            undosFirst = undosLast = null;
        else {
            undosFirst.next.prev = null;
            undosFirst = undosFirst.next;
        }
    }
}