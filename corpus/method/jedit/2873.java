//}}}
//{{{ handlePropertiesChanged() method
@EBHandler
public void handlePropertiesChanged(PropertiesChanged msg) {
    // pass on PropertiesChanged message to BufferSets so
    // they can resort themselves as needed.
    jEdit.visit(new JEditVisitorAdapter() {

        @Override
        public void visit(EditPane editPane) {
            editPane.getBufferSet().propertiesChanged();
        }
    });
}