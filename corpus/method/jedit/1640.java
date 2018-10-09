/**
        Get the parent namespace.
        Note: this isn't quite the same as getSuper().
        getSuper() returns 'this' if we are at the root namespace.
    */
public NameSpace getParent() {
    return parent;
}