/**
        Remove the variable from the namespace.
    */
public void unsetVariable(String name) {
    if (variables != null) {
        variables.remove(name);
        nameSpaceChanged();
    }
}