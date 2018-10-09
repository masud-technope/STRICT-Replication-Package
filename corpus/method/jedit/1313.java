public void addListener(Listener l) {
    listeners.addElement(new WeakReference(l, refQueue));
    // clean up old listeners
    Reference deadref;
    while ((deadref = refQueue.poll()) != null) {
        boolean ok = listeners.removeElement(deadref);
        if (ok) {
        //System.err.println("cleaned up weak ref: "+deadref);
        } else {
            if (Interpreter.DEBUG)
                Interpreter.debug("tried to remove non-existent weak ref: " + deadref);
        }
    }
}