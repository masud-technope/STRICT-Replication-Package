/**
		Parse the BSHBlock for the class definition and generate the class.
	*/
public abstract Class generateClass(String name, Modifiers modifiers, Class[] interfaces, Class superClass, BSHBlock block, boolean isInterface, CallStack callstack, Interpreter interpreter) throws EvalError;