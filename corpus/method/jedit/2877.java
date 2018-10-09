//}}}
//{{{ Private members
//{{{ getOwners() method
/**
	 * @return set of BufferSets that contain buffer
	 * @since 4.4pre1
	 */
public Set<BufferSet> getOwners(Buffer buffer) {
    final Set<BufferSet> candidates = new HashSet<BufferSet>();
    // Collect all BufferSets.
    jEdit.visit(new JEditVisitorAdapter() {

        @Override
        public void visit(EditPane editPane) {
            candidates.add(editPane.getBufferSet());
        }
    });
    // Remove all that doesn't contain the buffer.
    Iterator<BufferSet> i = candidates.iterator();
    while (i.hasNext()) {
        if (i.next().indexOf(buffer) == -1) {
            i.remove();
        }
    }
    // Remaining are the result.
    return candidates;
}