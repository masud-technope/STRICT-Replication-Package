/**
        Implements NameSource
        @return all variable and method names in this and all parent
        namespaces
    */
public String[] getAllNames() {
    Vector vec = new Vector();
    getAllNamesAux(vec);
    String[] names = new String[vec.size()];
    vec.copyInto(names);
    return names;
}