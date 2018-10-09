public Object getFromMap(Object map, Object key) {
    // Hashtable implements Map
    return ((Map) map).get(key);
}