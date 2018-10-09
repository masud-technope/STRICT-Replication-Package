private void mapClass(String className, Object source) {
    // add to package map
    String[] sa = splitClassname(className);
    String pack = sa[0];
    String clas = sa[1];
    Set set = (Set) packageMap.get(pack);
    if (set == null) {
        set = new HashSet();
        packageMap.put(pack, set);
    }
    set.add(className);
    // Add to classSource map
    Object obj = classSource.get(className);
    // explicitly set via setClassSource() )
    if (obj == null)
        classSource.put(className, source);
}