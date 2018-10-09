//}}}
//{{{ closeView() method
/**
	 * closeView() used by exit().
	 */
private static boolean closeView(View view, boolean callExit) {
    PerspectiveManager.setPerspectiveDirty(true);
    if (viewsFirst == viewsLast && callExit) {
        exit(view, false);
        // Coming here means the request has been canceled.
        return false;
    } else {
        if (!view.confirmToCloseDirty())
            return false;
        // move the dirty untitled buffers to the next open view's current editpane bufferset (first or last)
        boolean moveUntitled = jEdit.getBooleanProperty("autosaveUntitled");
        if (moveUntitled && !getBufferSetManager().getScope().equals(BufferSet.Scope.global)) {
            View targetView;
            if (view.equals(viewsFirst)) {
                targetView = viewsLast;
            } else {
                targetView = viewsFirst;
            }
            BufferSet bufferSet = targetView.getEditPane().getBufferSet();
            for (Buffer buffer : view.getBuffers()) {
                if (buffer.isUntitled() && buffer.isDirty()) {
                    bufferSet.addBuffer(buffer);
                }
            }
        }
        view.close();
        view.dispose();
        removeViewFromList(view);
        if (view == activeView)
            activeView = null;
        return true;
    }
}