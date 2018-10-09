//}}}
//{{{ setMessageAndClear() method
/**
	 * Show a message for a short period of time.
	 * @param message The message
	 * @since jEdit 3.2pre5
	 */
public void setMessageAndClear(String message) {
    setMessage(message);
    tempTimer = new Timer(0, new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
            // so if view is closed in the meantime...
            if (isShowing())
                setMessage(null);
        }
    });
    tempTimer.setInitialDelay(10000);
    tempTimer.setRepeats(false);
    tempTimer.start();
}