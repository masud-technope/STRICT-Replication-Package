//}}}
//{{{ pluginError() method
/**
	 * @param path
	 * @param messageProp - a property of a message to print
	 * @param args a list of arguments which correspond to {0} and {1} in the string to print.
	 */
static void pluginError(String path, String messageProp, Object[] args) {
    synchronized (pluginErrorLock) {
        if (pluginErrors == null)
            pluginErrors = new Vector<ErrorListDialog.ErrorEntry>();
        ErrorListDialog.ErrorEntry newEntry = new ErrorListDialog.ErrorEntry(path, messageProp, args);
        for (ErrorListDialog.ErrorEntry pluginError : pluginErrors) {
            if (pluginError.equals(newEntry))
                return;
        }
        pluginErrors.addElement(newEntry);
        if (isStartupDone()) {
            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    showPluginErrorDialog();
                }
            });
        }
    }
}