//}}}
//{{{ closeBuffer() method
/**
	 * Close a buffer.
	 * The buffer is first removed from the EditPane's bufferSet.
	 * If the buffer is not in any bufferSet after that, it is closed
	 * @param editPane the edit pane (it cannot be null)
	 * @param buffer the buffer (it cannot be null)
	 * @since jEdit 4.3pre15
	 */
public static void closeBuffer(EditPane editPane, Buffer buffer) {
    switch(bufferSetManager.getScope()) {
        case global:
            closeBuffer(editPane.getView(), buffer);
            break;
        case view:
            View[] views = jEdit.getViews();
            int viewOwner = 0;
            for (View view : views) {
                BufferSet bufferSet = view.getEditPane().getBufferSet();
                // no need to check every bufferSet since it's view scope
                if (bufferSet.indexOf(buffer) != -1) {
                    viewOwner++;
                    if (viewOwner > 1)
                        break;
                }
            }
            if (viewOwner > 1) {
                // the buffer is in several view, we can remove it from bufferSet
                bufferSetManager.removeBuffer(editPane, buffer);
            } else {
                closeBuffer(editPane.getView(), buffer);
            }
            break;
        case editpane:
            int bufferSetsCount = bufferSetManager.countBufferSets(buffer);
            if (bufferSetsCount < 2) {
                closeBuffer(editPane.getView(), buffer);
            } else {
                bufferSetManager.removeBuffer(editPane, buffer);
            }
            break;
    }
}