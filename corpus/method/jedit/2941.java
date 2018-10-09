public void run() {
    Log.log(Log.DEBUG, EditBus.class, message.toString());
    components.lock();
    try {
        sendImpl(message);
    } finally {
        components.unlock();
    }
}