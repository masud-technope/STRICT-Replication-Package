@Override
@SuppressWarnings("deprecation")
public void windowClosing(WindowEvent evt) {
    // TODO: Thread.stop is deprecated, this should probably be Thread.interrupt
    thread.stop();
    dispose();
}