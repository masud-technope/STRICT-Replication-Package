//{{{ undo() method
@Override
Selection[] undo(UndoManager mgr) {
    mgr.buffer.insert(offset, str);
    if (mgr.undoClearDirty == this)
        mgr.buffer.setDirty(false);
    return new Selection[] { new Selection.Range(offset, offset + str.length()) };
//}}}
}