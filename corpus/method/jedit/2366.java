/*
        I wish protected access were limited to children and not also
        package scope... I want this to be a singleton implemented by various
        children.
    */
protected  This(NameSpace namespace, Interpreter declaringInterpreter) {
    this.namespace = namespace;
    this.declaringInterpreter = declaringInterpreter;
//initCallStack( namespace );
}