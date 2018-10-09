//}}}
//{{{ getVisibleBuffers() method
private static Collection<Buffer> getVisibleBuffers() {
    final Set<Buffer> buffers = new HashSet<Buffer>();
    jEdit.visit(new JEditVisitorAdapter() {

        @Override
        public void visit(EditPane editPane) {
            buffers.add(editPane.getBuffer());
        }
    });
    return buffers;
}