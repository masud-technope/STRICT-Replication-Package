void add(String fullname) {
    String name = splitClassname(fullname)[1];
    Object have = super.get(name);
    if (have == null)
        super.put(name, fullname);
    else if (have instanceof AmbiguousName)
        ((AmbiguousName) have).add(fullname);
    else // String
    {
        AmbiguousName an = new AmbiguousName();
        an.add((String) have);
        an.add(fullname);
        super.put(name, an);
    }
}