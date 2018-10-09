Object getInstance() {
    if (instanceIsNull)
        return null;
    else if (instance == null) {
        // lazy instantiation
        instance = BeanShell.eval(null, BeanShell.getNameSpace(), code);
        if (instance == null) {
            // avoid re-running script if it gives
            // us null
            instanceIsNull = true;
        }
    }
    return instance;
}