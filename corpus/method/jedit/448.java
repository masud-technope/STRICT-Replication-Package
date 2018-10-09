public void advance(final int value) {
    try {
        SwingUtilities.invokeAndWait(new Runnable() {

            public void run() {
                progress.setValue(progress.getValue() + value);
            }
        });
        Thread.yield();
    } catch (Exception e) {
    }
}