/**
	 * Reports an I/O error.
	 *
	 * @param comp The component
	 * @param path The path name that caused the error
	 * @param messageProp The error message property name
	 * @param args Positional parameters
	 * @param urgency Logging urgency (level)
	 * @since jEdit 5.0pre1
	 */
public static void error(final Component comp, final String path, final String messageProp, final Object[] args, final int urgency) {
    Runnable r = new Runnable() {

        @Override
        public void run() {
            final Frame frame = JOptionPane.getFrameForComponent(comp);
            synchronized (errorLock) {
                error = true;
                errors.add(new ErrorListDialog.ErrorEntry(path, messageProp, args, urgency));
                if (errors.size() == 1) {
                    if (!errorDisplayerActive) {
                        ThreadUtilities.runInBackground(new ErrorDisplayer(frame));
                    }
                }
            }
        }
    };
    ThreadUtilities.runInDispatchThreadAndWait(r);
}