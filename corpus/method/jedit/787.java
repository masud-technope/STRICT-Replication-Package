/**
		 * Why this method exists: since both actionPerformed()
		 * and itemStateChanged() above can change the combo box,
		 * executing one of them can cause a chain reaction causing
		 * the other method to be called. This would cause the
		 * VFS subsystem to be called several times, which would
		 * cause a warning to show up if the first operation is
		 * still in progress, or cause a second operation to happen
		 * which is not really wanted especially if we're talking
		 * about a remove VFS. So the methods set a flag saying
		 * that something is going on, and this method resets
		 * the flag after the AWT thread is done with the
		 * current events.
		 */
private void resetLater() {
    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            isProcessingEvent = false;
        }
    });
}