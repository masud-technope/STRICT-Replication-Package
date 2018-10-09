public  NameSpace(NameSpace parent, BshClassManager classManager, String name) {
    // We might want to do this here rather than explicitly in Interpreter
    // for global (see also prune())
    //if ( classManager == null && (parent == null ) )
    // create our own class manager?
    setName(name);
    setParent(parent);
    setClassManager(classManager);
    // Register for notification of classloader change
    if (classManager != null)
        classManager.addListener(this);
}