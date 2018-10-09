//}}}
//{{{ done() method
public void done() {
    try {
        if (done == count) {
            SwingUtilities.invokeAndWait(new Runnable() {

                public void run() {
                    dispose();
                }
            });
        } else {
            SwingUtilities.invokeAndWait(new Runnable() {

                public void run() {
                    valueSoFar += roster.getOperation(done - 1).getMaximum();
                    progress.setValue(valueSoFar);
                    done++;
                }
            });
        }
    } catch (Exception e) {
    }
}