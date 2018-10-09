@SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == stop) {
        // TODO: Thread.stop is deprecated, this should probably be Thread.interrupt
        thread.stop();
        dispose();
    }
}