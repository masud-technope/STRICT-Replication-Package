//{{{ undo() method
@Override
public Selection[] undo(UndoManager mgr) {
    Selection[] retVal = null;
    Edit edit = last;
    while (edit != null) {
        retVal = edit.undo(mgr);
        edit = edit.prev;
    }
    return retVal;
//}}}
}