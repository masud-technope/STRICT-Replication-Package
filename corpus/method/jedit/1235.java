public String[] getAllNames() {
    insureInitialized();
    List names = new ArrayList();
    Iterator it = getPackagesSet().iterator();
    while (it.hasNext()) {
        String pack = (String) it.next();
        names.addAll(removeInnerClassNames(getClassesForPackage(pack)));
    }
    if (nameCompletionIncludesUnqNames)
        names.addAll(getUnqualifiedNameTable().keySet());
    return (String[]) names.toArray(new String[0]);
}