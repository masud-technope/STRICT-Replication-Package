public void done() {
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            currentPage++;
            pageChanged();
        }
    });
}