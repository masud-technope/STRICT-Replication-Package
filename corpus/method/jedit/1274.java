public static Collection removeInnerClassNames(Collection col) {
    List list = new ArrayList();
    list.addAll(col);
    Iterator it = list.iterator();
    while (it.hasNext()) {
        String name = (String) it.next();
        if (name.indexOf("$") != -1)
            it.remove();
    }
    return list;
}