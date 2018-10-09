public boolean equals(Object o) {
    SignatureKey target = (SignatureKey) o;
    if (types == null)
        return target.types == null;
    if (clas != target.clas)
        return false;
    if (!methodName.equals(target.methodName))
        return false;
    if (types.length != target.types.length)
        return false;
    for (int i = 0; i < types.length; i++) {
        if (types[i] == null) {
            if (!(target.types[i] == null))
                return false;
        } else if (!types[i].equals(target.types[i]))
            return false;
    }
    return true;
}