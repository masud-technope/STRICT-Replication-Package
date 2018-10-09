//{{{ add() method
public void add(UndoManager mgr, Edit edit) {
    _add(edit);
    // Edit to save memory for large search&replace operations
    if (last.prev != null) {
        Edit rep = mgr.getReplaceFromRemoveInsert(last.prev, last);
        if (rep != null)
            exchangeLastElement(rep);
    }
    // try to compress a sequence of Replace and Replace into a "CompressedReplace"
    if (last.prev != null) {
        Edit rep = mgr.getCompressedReplaceFromReplaceReplace(last.prev, last);
        if (rep != null)
            exchangeLastElement(rep);
    }
    // try to compress a sequence of CompressedReplace and Replace into a "CompressedReplace"
    if (last.prev != null) {
        Edit rep = mgr.getCompressedReplaceFromReplaceReplace(last.prev, last);
        if (rep != null)
            exchangeLastElement(rep);
    }
//}}}
}