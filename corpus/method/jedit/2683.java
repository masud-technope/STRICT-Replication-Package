//}}}
//{{{ getMergeEdit() method
private Edit getMergeEdit() {
    return (compoundEdit != null ? compoundEdit.last : getLastEdit());
}