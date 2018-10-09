// end primary set and get methods
/**
		Get a reference to the interpreter (global namespace), cast
		to the specified interface type.  Assuming the appropriate
		methods of the interface are defined in the interpreter, then you may
		use this interface from Java, just like any other Java object.
		<p>

		For example:
		<pre>
			Interpreter interpreter = new Interpreter();
			// define a method called run()
			interpreter.eval("run() { ... }");

			// Fetch a reference to the interpreter as a Runnable
			Runnable runnable =
				(Runnable)interpreter.getInterface( Runnable.class );
		</pre>
		<p>

		Note that the interpreter does *not* require that any or all of the
		methods of the interface be defined at the time the interface is
		generated.  However if you attempt to invoke one that is not defined
		you will get a runtime exception.
		<p>

		Note also that this convenience method has exactly the same effect as
		evaluating the script:
		<pre>
			(Type)this;
		</pre>
		<p>

		For example, the following is identical to the previous example:
		<p>

		<pre>
			// Fetch a reference to the interpreter as a Runnable
			Runnable runnable =
				(Runnable)interpreter.eval( "(Runnable)this" );
		</pre>
		<p>

		<em>Version requirement</em> Although standard Java interface types
		are always available, to be used with arbitrary interfaces this
		feature requires that you are using Java 1.3 or greater.
		<p>

		@throws EvalError if the interface cannot be generated because the
		version of Java does not support the proxy mechanism.
	*/
public Object getInterface(Class interf) throws EvalError {
    try {
        return globalNameSpace.getThis(this).getInterface(interf);
    } catch (UtilEvalError e) {
        throw e.toEvalError(SimpleNode.JAVACODE, new CallStack());
    }
}