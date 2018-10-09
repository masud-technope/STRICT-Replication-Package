//}}}
//{{{ resetClearDirty method
public void resetClearDirty() {
    redoClearDirty = getLastEdit();
    if (redosFirst instanceof CompoundEdit)
        undoClearDirty = ((CompoundEdit) redosFirst).first;
    else
        undoClearDirty = redosFirst;
}