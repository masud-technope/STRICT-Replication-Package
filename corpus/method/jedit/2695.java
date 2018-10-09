//{{{ redo() method
@Override
public Selection[] redo(UndoManager mgr) {
    Selection[] retVal = null;
    Edit edit = first;
    while (edit != null) {
        retVal = edit.redo(mgr);
        edit = edit.next;
    }
    return retVal;
//}}}
}