//}}}
//{{{ getBuffers() method
/**
	 * Returns all Buffers opened in this View,
	 * Sorted according to View options. (as of jEdit 5.2)
	 * With order preserved for unsorted buffersets (as of jEdit 5.3)
	 * @since jEdit 5.1
	 */
public Buffer[] getBuffers() {
    BufferSetManager mgr = jEdit.getBufferSetManager();
    Collection<Buffer> retval = null;
    for (EditPane ep : getEditPanes()) {
        BufferSet bs = ep.getBufferSet();
        if (retval == null) {
            Comparator<Buffer> sorter = bs.getSorter();
            if (sorter == null)
                retval = new LinkedHashSet<Buffer>();
            else
                retval = new TreeSet<Buffer>(sorter);
        }
        Collections.addAll(retval, bs.getAllBuffers());
        // are the same and we got what we need.
        if (mgr.getScope() != BufferSet.Scope.editpane)
            break;
    }
    Buffer[] bufs = new Buffer[retval.size()];
    retval.toArray(bufs);
    return bufs;
}