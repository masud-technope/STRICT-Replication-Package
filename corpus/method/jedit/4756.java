//}}}
//{{{ deactivate() method
void deactivate() {
    String[] classes = jar.getClasses();
    if (classes != null) {
        for (String aClass : classes) {
            Object loader = classHash.get(aClass);
            if (loader == this)
                classHash.remove(aClass);
        /* else two plugins provide same class! */
        }
    }
    String[] resources = jar.getResources();
    if (resources == null)
        return;
    for (String resource : resources) {
        Object loader = resourcesHash.get(resource);
        if (loader == this)
            resourcesHash.remove(resource);
    /* else two plugins provide same resource! */
    }
}