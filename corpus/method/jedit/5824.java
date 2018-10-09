@Override
public void windowOpened(WindowEvent evt) {
    if (done)
        return;
    done = true;
    thread = new RosterThread();
    thread.start();
}