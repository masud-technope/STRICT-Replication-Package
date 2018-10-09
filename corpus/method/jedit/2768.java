//}}}
//{{{ setDirty() method
/**
	 * Sets the 'dirty' (changed since last save) flag of this buffer.
	 */
@Override
public void setDirty(boolean d) {
    boolean old_d = isDirty();
    if (d && getLength() == initialLength) {
        // for untitled, do not check if the content existed before
        if (jEdit.getBooleanProperty("useMD5forDirtyCalculation") && !isUntitled())
            d = !Arrays.equals(calculateHash(), md5hash);
    }
    super.setDirty(d);
    boolean editable = isEditable();
    if (d) {
        if (editable)
            setFlag(AUTOSAVE_DIRTY, true);
    } else {
        setFlag(AUTOSAVE_DIRTY, false);
        if (autosaveFile != null)
            autosaveFile.delete();
    }
    if (d != old_d && editable) {
        EditBus.send(new BufferUpdate(this, null, BufferUpdate.DIRTY_CHANGED));
    }
}