public void error(final String message) {
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            dispose();
            JOptionPane.showMessageDialog(null, message, "Installation aborted", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    });
}