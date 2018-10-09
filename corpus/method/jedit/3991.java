//{{{ update() method
public void update() {
    BufferSet.Scope scope = jEdit.getBufferSetManager().getScope();
    if (currentScope == null || !currentScope.equals(scope)) {
        bufferSetLabel.setText(scope.toString().substring(0, 1).toUpperCase());
        bufferSetLabel.setToolTipText(jEdit.getProperty("view.status.bufferset-tooltip", new Object[] { scope }));
        currentScope = scope;
    }
//}}}
}