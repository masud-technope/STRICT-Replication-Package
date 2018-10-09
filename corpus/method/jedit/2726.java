//{{{ close() method
/**
	 * close the buffer
	 * @param doNotSave when true, we do not want to keep the autosave even for untitled
	 *	e.g.: we closed the buffer by hand
	 */
void close(boolean doNotSave) {
    setFlag(CLOSED, true);
    boolean autosaveUntitled = jEdit.getBooleanProperty("autosaveUntitled");
    if (autosaveFile != null && (doNotSave || !(isUntitled() && autosaveUntitled)))
        autosaveFile.delete();
    // except we close it manually and do not want to save
    if (!doNotSave && isUntitled() && autosaveUntitled) {
        autosave();
    }
    // notify clients with -wait
    if (waitSocket != null) {
        try {
            waitSocket.getOutputStream().write('\0');
            waitSocket.getOutputStream().flush();
            waitSocket.getInputStream().close();
            waitSocket.getOutputStream().close();
            waitSocket.close();
        } catch (IOException io) {
        }
    }
}