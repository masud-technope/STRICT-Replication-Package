//}}}
//{{{ contentRemoved() method
public void contentRemoved(int offset, int length, String text, boolean clearDirty) {
    Edit toMerge = getMergeEdit();
    if (!clearDirty && toMerge instanceof Remove && redosFirst == null) {
        Remove rem = (Remove) toMerge;
        if (rem.offset == offset) {
            String newStr = rem.str.concat(text);
            KillRing.getInstance().changed(rem.str, newStr);
            rem.str = newStr;
            return;
        } else if (offset + length == rem.offset) {
            String newStr = text.concat(rem.str);
            KillRing.getInstance().changed(rem.str, newStr);
            rem.offset = offset;
            rem.str = newStr;
            return;
        }
    }
    // use String.intern() here as new Strings are created in
    // JEditBuffer.remove() via undoMgr.contentRemoved(... getText() ...);
    Remove rem = new Remove(offset, text.intern());
    if (clearDirty) {
        redoClearDirty = getLastEdit();
        undoClearDirty = rem;
    }
    if (compoundEdit != null)
        compoundEdit.add(this, rem);
    else {
        reviseUndoId();
        addEdit(rem);
    }
    KillRing.getInstance().add(rem.str);
}