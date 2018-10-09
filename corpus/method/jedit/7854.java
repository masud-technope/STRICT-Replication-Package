protected void fireNodesChanged(Object source, Object[] path, int[] childIndices, Object[] children) {
    Object[] listeners = listenerList.getListenerList();
    TreeModelEvent modelEvent = null;
    for (int i = listeners.length - 2; i >= 0; i -= 2) {
        if (listeners[i] != TreeModelListener.class)
            continue;
        if (modelEvent == null) {
            modelEvent = new TreeModelEvent(source, path, childIndices, children);
        }
        ((TreeModelListener) listeners[i + 1]).treeNodesChanged(modelEvent);
    }
}