//}}}
//{{{ activate() method
void activate() {
    if (jar.getPlugin() != null) {
        String _delegate = jEdit.getProperty("plugin." + jar.getPlugin().getClassName() + ".class_loader_delegate");
        delegateFirst = _delegate == null || "true".equals(_delegate);
    }
    String[] classes = jar.getClasses();
    if (classes != null) {
        for (String aClass : classes) classHash.put(aClass, this);
    }
    String[] resources = jar.getResources();
    if (resources != null) {
        for (String resource : resources) resourcesHash.put(resource, this);
    }
}