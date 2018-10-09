public void addListener(ClassPathListener l) {
    listeners.addElement(new WeakReference(l));
}