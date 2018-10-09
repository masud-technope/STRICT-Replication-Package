/**
    	Return the primitive value stored in its java.lang wrapper class
	*/
public Object getValue() {
    if (value == Special.NULL_VALUE)
        return null;
    else if (value == Special.VOID_TYPE)
        throw new InterpreterError("attempt to unwrap void type");
    else
        return value;
}