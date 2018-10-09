public void setMaximum(final int max) {
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            progress.setMaximum(max);
        }
    });
}