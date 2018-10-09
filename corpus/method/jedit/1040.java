public int hashCode() {
    if (hashCode == 0) {
        hashCode = clas.hashCode() * methodName.hashCode();
        if (// no args method
        types == null)
            return hashCode;
        for (int i = 0; i < types.length; i++) {
            int hc = types[i] == null ? 21 : types[i].hashCode();
            hashCode = hashCode * (i + 1) + hc;
        }
    }
    return hashCode;
}