private void passToView(final KeyEvent evt) {
    if (temp)
        view.removeToolBar(ActionBar.this);
    view.getTextArea().requestFocus();
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            view.getTextArea().requestFocus();
            view.getInputHandler().setRepeatCount(repeatCount);
            view.getInputHandler().processKeyEvent(evt, View.ACTION_BAR, false);
        }
    });
}