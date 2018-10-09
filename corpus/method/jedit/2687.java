//}}}
//{{{ contentInserted() method
public void contentInserted(int offset, int length, String text, boolean clearDirty) {
    Edit toMerge = getMergeEdit();
    if (!clearDirty && toMerge instanceof Insert && redosFirst == null) {
        Insert ins = (Insert) toMerge;
        if (ins.offset == offset) {
            ins.str = text.concat(ins.str);
            return;
        } else if (ins.offset + ins.str.length() == offset) {
            ins.str = ins.str.concat(text);
            return;
        }
    }
    Insert ins = new Insert(offset, text);
    if (clearDirty) {
        redoClearDirty = getLastEdit();
        undoClearDirty = ins;
    }
    if (compoundEdit != null)
        compoundEdit.add(this, ins);
    else {
        reviseUndoId();
        addEdit(ins);
    }
}