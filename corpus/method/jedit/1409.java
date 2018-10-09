/**
		Specify whether, in interactive mode, the interpreter exits Java upon
		end of input.  If true, when in interactive mode the interpreter will
		issue a System.exit(0) upon eof.  If false the interpreter no
		System.exit() will be done.
		<p>
		Note: if you wish to cause an EOF externally you can try closing the
		input stream.  This is not guaranteed to work in older versions of Java
		due to Java limitations, but should work in newer JDK/JREs.  (That was
		the motivation for the Java NIO package).
	*/
public void setExitOnEOF(boolean value) {
    // ug
    exitOnEOF = // ug
    value;
}