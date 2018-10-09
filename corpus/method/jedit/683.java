//}}}
//{{{ createInterpreter() method
protected static Interpreter createInterpreter(NameSpace nameSpace) {
    return new Interpreter(null, System.out, System.err, false, nameSpace);
}