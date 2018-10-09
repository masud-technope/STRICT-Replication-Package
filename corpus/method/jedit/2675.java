//{{{ redo() method
@Override
Selection[] redo(UndoManager mgr) {
    mgr.buffer.insert(offset, str);
    if (mgr.redoClearDirty == this)
        mgr.buffer.setDirty(false);
    int caret = offset + str.length();
    return new Selection[] { new Selection.Range(caret, caret) };
//}}}
}