public void run() {
    synchronized (errorLock) {
        // 2 threads might have been spawn simultaneously
        if (errorDisplayerActive)
            return;
        errorDisplayerActive = true;
    }
    // The loop breaks only when errors.size() == 0
    while (true) {
        synchronized (errorLock) {
            if (errors.size() == 0) {
                errorDisplayerActive = false;
                break;
            }
        }
        // We know that there are errors, but let's wait a bit.
        // Maybe there are more accumulating?
        // We'll stay here until they stop coming out.
        int errCount1 = -1, errCount2 = 0;
        while (//{{{
        errCount1 != //{{{
        errCount2) {
            // errors is a Vector and Vectors are synchronized
            errCount1 = errors.size();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                break;
            }
            errCount2 = errors.size();
        //}}}
        }
        // For a while new errors didn't appear.
        // Let's display those which we already have.
        // While the dialog will be displayed,
        // there may arrive the next, so we stay in
        // the loop.
        Vector<ErrorListDialog.ErrorEntry> errorsCopy;
        synchronized (errorLock) {
            errorsCopy = new Vector<ErrorListDialog.ErrorEntry>(errors);
            errors.clear();
            error = false;
        }
        showDialog(frame, errorsCopy);
    }
}