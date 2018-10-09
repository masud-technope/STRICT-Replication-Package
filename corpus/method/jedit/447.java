public void message(final String message) {
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            progress.setString(message);
        }
    });
}