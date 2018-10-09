/**
		Resolve possibly complex name to an object value.

		Throws EvalError on various failures.
		A null object value is indicated by a Primitive.NULL.
		A return type of Primitive.VOID comes from attempting to access
		an undefined variable.

		Some cases:
			myVariable
			myVariable.foo
			myVariable.foo.bar
			java.awt.GridBagConstraints.BOTH
			my.package.stuff.MyClass.someField.someField...

		Interpreter reference is necessary to allow resolution of 
		"this.interpreter" magic field.
		CallStack reference is necessary to allow resolution of 
		"this.caller" magic field.
		"this.callstack" magic field.
	*/
public Object toObject(CallStack callstack, Interpreter interpreter) throws UtilEvalError {
    return toObject(callstack, interpreter, false);
}