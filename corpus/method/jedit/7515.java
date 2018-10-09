//}}}
//{{{ handleViewUpdate() method
@EBHandler
public void handleViewUpdate(ViewUpdate msg) {
    // only have my view handle each update message
    if (msg.getView() == null || msg.getView() != this)
        return;
    final int check = jEdit.getIntegerProperty("checkFileStatus");
    if ((check == 0) || !jEdit.isStartupDone())
        return;
    // another program, which could have alterered file on disk.
    if ((msg.getWhat() == ViewUpdate.EDIT_PANE_CHANGED || msg.getWhat() == ViewUpdate.ACTIVATED) && ((check & GeneralOptionPane.checkFileStatus_focusBuffer) > 0))
        jEdit.checkBufferStatus(View.this, true);
    else if ((msg.getWhat() == ViewUpdate.ACTIVATED) && (check & GeneralOptionPane.checkFileStatus_focus) > 0)
        jEdit.checkBufferStatus(View.this, (check != GeneralOptionPane.checkFileStatus_focus));
}