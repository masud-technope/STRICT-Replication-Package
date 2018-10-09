/**
        Used for serialization
    */
public void prune() {
    if (this.classManager == null)
        // XXX if we keep the createClassManager in getClassManager then we can axe
        // this?
        setClassManager(BshClassManager.createClassManager(null));
    setParent(null);
}