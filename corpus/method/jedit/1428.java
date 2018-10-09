/**
		The main constructor.
		All constructors should now pass through here.

		@param namespace If namespace is non-null then this interpreter's
		root namespace will be set to the one provided.  If it is null a new
		one will be created for it.
		@param parent The parent interpreter if this interpreter is a child
			of another.  May be null.  Children share a BshClassManager with
			their parent instance.
		@param sourceFileInfo An informative string holding the filename
		or other description of the source from which this interpreter is
		reading... used for debugging.  May be null.
	*/
public  Interpreter(Reader in, PrintStream out, PrintStream err, boolean interactive, NameSpace namespace, Interpreter parent, String sourceFileInfo) {
    //System.out.println("New Interpreter: "+this +", sourcefile = "+sourceFileInfo );
    parser = new Parser(in);
    long t1 = System.currentTimeMillis();
    this.in = in;
    this.out = out;
    this.err = err;
    this.interactive = interactive;
    debug = err;
    this.parent = parent;
    if (parent != null)
        setStrictJava(parent.getStrictJava());
    this.sourceFileInfo = sourceFileInfo;
    BshClassManager bcm = BshClassManager.createClassManager(this);
    if (namespace == null)
        this.globalNameSpace = new NameSpace(bcm, "global");
    else
        this.globalNameSpace = namespace;
    /*
			Create the root "bsh" system object if it doesn't exist.
		*/
    if (!(getu("bsh") instanceof org.gjt.sp.jedit.bsh.This))
        initRootSystemObject();
    if (interactive)
        loadRCFiles();
    long t2 = System.currentTimeMillis();
    if (Interpreter.DEBUG)
        Interpreter.debug("Time to initialize interpreter: " + (t2 - t1));
}