private void bufferLoaded() {
    synchronized (this) {
        if (!loadedEventReceived) {
            EditBus.removeFromBus(this);
            loadedEventReceived = true;
            ThreadUtilities.runInDispatchThread(this);
        }
    }
}