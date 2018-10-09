//{{{ undo() method
@Override
Selection[] undo(UndoManager mgr) {
    Selection[] s = null;
    for (int i = offsets.getSize() - 1; i >= 0; i--) {
        offset = offsets.get(i);
        s = super.undo(mgr);
    }
    return s;
//}}}
}