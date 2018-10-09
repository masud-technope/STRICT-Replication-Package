public boolean isMap(Object obj) {
    if (obj instanceof Map)
        return true;
    else
        return super.isMap(obj);
}