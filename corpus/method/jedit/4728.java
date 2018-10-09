private void showDialog(final Frame frame, final Vector<ErrorListDialog.ErrorEntry> errors) {
    try {
        EventQueue.invokeAndWait(new Runnable() {

            public void run() {
                String caption = jEdit.getProperty("ioerror.caption" + (errors.size() == 1 ? "-1" : ""), new Integer[] { Integer.valueOf(errors.size()) });
                new ErrorListDialog(frame.isShowing() ? frame : jEdit.getFirstView(), jEdit.getProperty("ioerror.title"), caption, errors, false);
            }
        });
    } catch (InterruptedException ie) {
        Thread.currentThread().interrupt();
    } catch (InvocationTargetException ite) {
        Log.log(Log.ERROR, ErrorDisplayer.class, ite);
    }
}