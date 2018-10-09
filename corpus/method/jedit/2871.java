//}}}
//{{{ setScope() method
public void setScope(BufferSet.Scope scope) {
    if (scope == this.scope)
        return;
    jEdit.setProperty("bufferset.scope", scope.name());
    if (scope.compareTo(this.scope) > 0) {
        // The new scope is wider
        if (scope == BufferSet.Scope.global) {
            final Buffer[] buffers = jEdit.getBuffers();
            jEdit.visit(new JEditVisitorAdapter() {

                @Override
                public void visit(EditPane editPane) {
                    BufferSet bufferSet = editPane.getBufferSet();
                    for (Buffer buffer : buffers) {
                        bufferSet.addBuffer(buffer);
                    }
                }
            });
        } else {
            final Map<View, Set<Buffer>> buffersMap = new HashMap<View, Set<Buffer>>();
            jEdit.visit(new JEditVisitorAdapter() {

                @Override
                public void visit(EditPane editPane) {
                    BufferSet bufferSet = editPane.getBufferSet();
                    Buffer[] buffers = bufferSet.getAllBuffers();
                    Set<Buffer> set = buffersMap.get(editPane.getView());
                    if (set == null) {
                        set = new HashSet<Buffer>();
                        buffersMap.put(editPane.getView(), set);
                    }
                    set.addAll(Arrays.asList(buffers));
                }
            });
            jEdit.visit(new JEditVisitorAdapter() {

                @Override
                public void visit(EditPane editPane) {
                    BufferSet bufferSet = editPane.getBufferSet();
                    Set<Buffer> set = buffersMap.get(editPane.getView());
                    for (Buffer buffer : set) {
                        bufferSet.addBuffer(buffer);
                    }
                }
            });
        }
    }
    this.scope = scope;
    EditBus.send(new PropertiesChanged(this));
}