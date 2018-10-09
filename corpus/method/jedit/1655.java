public void setParent(NameSpace parent) {
    this.parent = parent;
    // If we are disconnected from root we need to handle the def imports
    if (parent == null)
        loadDefaultImports();
}