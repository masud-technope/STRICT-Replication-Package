//}}}
//{{{ redo() method
public Selection[] redo() {
    if (insideCompoundEdit())
        throw new InternalError("Unbalanced begin/endCompoundEdit()");
    if (redosFirst == null)
        return null;
    else {
        reviseUndoId();
        undoCount++;
        Selection[] s = redosFirst.redo(this);
        undosLast = redosFirst;
        if (undosFirst == null)
            undosFirst = undosLast;
        redosFirst = redosFirst.next;
        return s;
    }
}