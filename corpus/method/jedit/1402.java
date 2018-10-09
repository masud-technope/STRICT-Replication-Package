/**
		Run the text only interpreter on the command line or specify a file.
	*/
public static void main(String[] args) {
    if (args.length > 0) {
        String filename = args[0];
        String[] bshArgs;
        if (args.length > 1) {
            bshArgs = new String[args.length - 1];
            System.arraycopy(args, 1, bshArgs, 0, args.length - 1);
        } else
            bshArgs = new String[0];
        Interpreter interpreter = new Interpreter();
        //System.out.println("run i = "+interpreter);
        interpreter.setu("bsh.args", bshArgs);
        try {
            Object result = interpreter.source(filename, interpreter.globalNameSpace);
            if (result instanceof Class)
                try {
                    invokeMain((Class) result, bshArgs);
                } catch (Exception e) {
                    Object o = e;
                    if (e instanceof InvocationTargetException)
                        o = ((InvocationTargetException) e).getTargetException();
                    System.err.println("Class: " + result + " main method threw exception:" + o);
                }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
        } catch (TargetError e) {
            System.out.println("Script threw exception: " + e);
            if (e.inNativeCode())
                e.printStackTrace(DEBUG, System.err);
        } catch (EvalError e) {
            System.out.println("Evaluation Error: " + e);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    } else {
        // Workaround for JDK bug 4071281, where system.in.available()
        // returns too large a value. This bug has been fixed in JDK 1.2.
        InputStream src;
        if (System.getProperty("os.name").startsWith("Windows") && System.getProperty("java.version").startsWith("1.1.")) {
            src = new FilterInputStream(System.in) {

                public int available() throws IOException {
                    return 0;
                }
            };
        } else
            src = System.in;
        Reader in = new CommandLineReader(new InputStreamReader(src));
        Interpreter interpreter = new Interpreter(in, System.out, System.err, true);
        interpreter.run();
    }
}