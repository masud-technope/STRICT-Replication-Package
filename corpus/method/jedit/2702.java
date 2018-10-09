//{{{ undo() method
@Override
Selection[] undo(UndoManager mgr) {
    mgr.buffer.remove(offset, strInsert.length());
    mgr.buffer.insert(offset, strRemove);
    assert mgr.undoClearDirty != this;
    return new Selection[] { new Selection.Range(offset, offset + strRemove.length()) };
//}}}
}