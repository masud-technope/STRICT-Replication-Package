//}}}
//{{{ setMessage() method
/**
	 * Displays a status message.
	 * @param message the message to display, it can be null
	 */
public void setMessage(String message) {
    if (tempTimer != null) {
        tempTimer.stop();
        tempTimer = null;
    }
    setMessageComponent(this.message);
    if (message == null) {
        if (view.getMacroRecorder() != null)
            this.message.setText(jEdit.getProperty("view.status.recording"));
        else
            this.message.setText(" ");
    } else
        this.message.setText(message);
}