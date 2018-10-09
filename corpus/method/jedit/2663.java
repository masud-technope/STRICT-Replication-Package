//}}}
//{{{ endCompoundEdit() method
public void endCompoundEdit() {
    if (compoundEditCount == 0) {
        Log.log(Log.WARNING, this, new Exception("Unbalanced begin/endCompoundEdit()"));
        return;
    } else if (compoundEditCount == 1) {
        if (compoundEdit.first == null)
            /* nothing done between begin/end calls */
            ;
        else if (compoundEdit.first == compoundEdit.last)
            addEdit(compoundEdit.first);
        else
            addEdit(compoundEdit);
        compoundEdit = null;
    }
    compoundEditCount--;
}