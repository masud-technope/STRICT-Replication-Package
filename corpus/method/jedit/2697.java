//{{{ redo() method
@Override
Selection[] redo(UndoManager mgr) {
    Selection[] s = null;
    for (int i = 0; i < offsets.getSize(); i++) {
        offset = offsets.get(i);
        s = super.redo(mgr);
    }
    return s;
//}}}
}