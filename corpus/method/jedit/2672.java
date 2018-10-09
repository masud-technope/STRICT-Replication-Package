//{{{ redo() method
@Override
Selection[] redo(UndoManager mgr) {
    mgr.buffer.remove(offset, str.length());
    if (mgr.redoClearDirty == this)
        mgr.buffer.setDirty(false);
    return new Selection[] { new Selection.Range(offset, offset) };
//}}}
}