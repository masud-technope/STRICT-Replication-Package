/**
		Invoke a super.method() style superclass method on an object instance.
		This is not a normal function of the Java reflection API and is
		provided by generated class accessor methods.
	*/
public abstract Object invokeSuperclassMethod(BshClassManager bcm, Object instance, String methodName, Object[] args) throws UtilEvalError, ReflectError, InvocationTargetException;