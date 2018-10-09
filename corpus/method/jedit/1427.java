public  Interpreter(Reader in, PrintStream out, PrintStream err, boolean interactive, NameSpace namespace) {
    this(in, out, err, interactive, namespace, null, null);
}