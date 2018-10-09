//{{{ redo() method
@Override
Selection[] redo(UndoManager mgr) {
    mgr.buffer.remove(offset, strRemove.length());
    mgr.buffer.insert(offset, strInsert);
    if (mgr.redoClearDirty == this)
        mgr.buffer.setDirty(false);
    int caret = offset + strInsert.length();
    return new Selection[] { new Selection.Range(caret, caret) };
//}}}
}