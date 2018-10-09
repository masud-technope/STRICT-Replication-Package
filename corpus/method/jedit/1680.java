/**
        @param parent the parent namespace of this namespace.  Child namespaces
        inherit all variables and methods of their parent and can (of course)
        override / shadow them.
        @param name a name
    */
public  NameSpace(NameSpace parent, String name) {
    // Note: in this case parent must have a class manager.
    this(parent, null, name);
}