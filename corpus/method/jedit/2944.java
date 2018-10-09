public synchronized void unlock() {
    lock--;
    if (lock == 0) {
        for (Object comp : add) addComponent(comp);
        for (Object comp : remove) removeComponent(comp);
        add.clear();
        remove.clear();
    }
}