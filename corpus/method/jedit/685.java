//}}}
//{{{ init() method
/**
	 * Initialize things. It is called by the constructor.
	 * You can override it to import other packages
	 */
protected void init() {
    global.importPackage("org.gjt.sp.jedit");
    global.importPackage("org.gjt.sp.jedit.buffer");
    global.importPackage("org.gjt.sp.jedit.syntax");
    global.importPackage("org.gjt.sp.jedit.textarea");
    global.importPackage("org.gjt.sp.util");
}