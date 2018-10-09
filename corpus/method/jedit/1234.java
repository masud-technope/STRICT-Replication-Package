private UnqualifiedNameTable buildUnqualifiedNameTable() {
    UnqualifiedNameTable unqNameTable = new UnqualifiedNameTable();
    // add component names
    if (compPaths != null)
        for (int i = 0; i < compPaths.size(); i++) {
            Set s = ((BshClassPath) compPaths.get(i)).classSource.keySet();
            Iterator it = s.iterator();
            while (it.hasNext()) unqNameTable.add((String) it.next());
        }
    // add ours
    Iterator it = classSource.keySet().iterator();
    while (it.hasNext()) unqNameTable.add((String) it.next());
    return unqNameTable;
}