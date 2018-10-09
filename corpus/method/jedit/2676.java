//{{{ undo() method
@Override
Selection[] undo(UndoManager mgr) {
    mgr.buffer.remove(offset, str.length());
    if (mgr.undoClearDirty == this)
        mgr.buffer.setDirty(false);
    return new Selection[] { new Selection.Range(offset, offset) };
//}}}
}