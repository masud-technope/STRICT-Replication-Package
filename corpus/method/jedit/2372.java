/**
        Bind a This reference to a parent's namespace with the specified
        declaring interpreter.  Also re-init the callstack.  It's necessary
        to bind a This reference before it can be used after deserialization.
        This is used by the bsh load() command.
        <p>

        This is a static utility method because it's used by a bsh command
        bind() and the interpreter doesn't currently allow access to direct
        methods of This objects (small hack)
    */
public static void bind(This ths, NameSpace namespace, Interpreter declaringInterpreter) {
    ths.namespace.setParent(namespace);
    ths.declaringInterpreter = declaringInterpreter;
}