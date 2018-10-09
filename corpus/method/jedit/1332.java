public Object putInMap(Object map, Object key, Object value) {
    // Hashtable implements Map
    return ((Map) map).put(key, value);
}