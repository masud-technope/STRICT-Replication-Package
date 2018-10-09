//}}}
//{{{ closeDuplicateBuffers() method
/** Used if exclusive buffersets are enabled */
private void closeDuplicateBuffers(EditPaneUpdate epu) {
    if (!jEdit.getBooleanProperty("buffersets.exclusive"))
        return;
    final BufferSet.Scope scope = jEdit.getBufferSetManager().getScope();
    if (scope == BufferSet.Scope.global)
        return;
    final EditPane ep = epu.getEditPane();
    /* Only one view needs to handle this message, since
		   we iterate through all the other views */
    final View view = ep.getView();
    if (view != this)
        return;
    final Buffer b = ep.getBuffer();
    if (b.isDirty())
        return;
    jEdit.visit(new JEditVisitorAdapter() {

        @Override
        public void visit(EditPane editPane) {
            if (editPane == ep || (scope == BufferSet.Scope.view && editPane.getView() == view))
                return;
            if (editPane.getBufferSet().indexOf(b) < 0)
                return;
            jEdit.getBufferSetManager().removeBuffer(editPane, b);
        }
    });
}