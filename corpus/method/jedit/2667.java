//}}}
//{{{ beginCompoundEdit() method
public void beginCompoundEdit() {
    if (compoundEditCount == 0) {
        compoundEdit = new CompoundEdit();
        reviseUndoId();
    }
    compoundEditCount++;
}