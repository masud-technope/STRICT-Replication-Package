//}}}
//{{{ undo() method
public Selection[] undo() {
    if (insideCompoundEdit())
        throw new InternalError("Unbalanced begin/endCompoundEdit()");
    if (undosLast == null)
        return null;
    else {
        reviseUndoId();
        undoCount--;
        Selection s[] = undosLast.undo(this);
        redosFirst = undosLast;
        undosLast = undosLast.prev;
        if (undosLast == null)
            undosFirst = null;
        return s;
    }
}