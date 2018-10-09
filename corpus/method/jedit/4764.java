/**
	 * Checks buffer status on disk and shows the dialog box
	 * informing the user that buffers changed on disk, if necessary.
	 * @param view The view
	 * @param currentBuffer indicates whether to check only the current buffer
	 * @since jEdit 4.2pre1
	 */
public static void checkBufferStatus(View view, boolean currentBuffer) {
    Log.log(Log.DEBUG, jEdit.class, "checkBufferStatus for " + (currentBuffer ? "current buffer: " + view.getBuffer() : "all buffers"));
    // still need to call the status check even if the option is
    // off, so that the write protection is updated if it changes
    // on disk
    // auto reload changed buffers?
    boolean autoReload = getBooleanProperty("autoReload");
    // the problem with this is that if we have two edit panes
    // looking at the same buffer and the file is reloaded both
    // will jump to the same location
    visit(new SaveCaretInfoVisitor());
    Buffer buffer = buffersFirst;
    int[] states = new int[bufferCount];
    int i = 0;
    boolean notifyFileChanged = false;
    while (buffer != null) {
        if (currentBuffer && buffer != view.getBuffer()) {
            buffer = buffer.next;
            i++;
            continue;
        }
        states[i] = buffer.checkFileStatus(view);
        switch(states[i]) {
            case Buffer.FILE_CHANGED:
                if (buffer.getAutoReload()) {
                    if (buffer.isDirty())
                        notifyFileChanged = true;
                    else {
                        buffer.load(view, true);
                        // File can be changed into link on disk or vice versa, so update
                        // file-path,buffer key value pair in bufferHash
                        final Buffer b = buffer;
                        Runnable runnable = new Runnable() {

                            public void run() {
                                updateBufferHash(b);
                            }
                        };
                        AwtRunnableQueue.INSTANCE.runAfterIoTasks(runnable);
                    }
                } else
                    // no automatic reload even if general setting is true
                    autoReload = false;
                // don't notify user if "do nothing" was chosen
                if (buffer.getAutoReloadDialog())
                    notifyFileChanged = true;
                break;
            case Buffer.FILE_DELETED:
                notifyFileChanged = true;
                break;
        }
        buffer = buffer.next;
        i++;
    }
    if (notifyFileChanged)
        new FilesChangedDialog(view, states, autoReload);
}