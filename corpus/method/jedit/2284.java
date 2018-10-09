/**
		Primary object constructor
		This method is simpler than those that must resolve general method
		invocation because constructors are not inherited.
	 <p/>
	 This method determines whether to attempt to use non-public constructors
	 based on Capabilities.haveAccessibility() and will set the accessibilty
	 flag on the method as necessary.
	 <p/>
	*/
static Object constructObject(Class clas, Object[] args) throws ReflectError, InvocationTargetException {
    if (clas.isInterface())
        throw new ReflectError("Can't create instance of an interface: " + clas);
    Object obj = null;
    Class[] types = Types.getTypes(args);
    Constructor con = null;
    // Find the constructor.
    // (there are no inherited constructors to worry about)
    Constructor[] constructors = Capabilities.haveAccessibility() ? clas.getDeclaredConstructors() : clas.getConstructors();
    if (Interpreter.DEBUG)
        Interpreter.debug("Looking for most specific constructor: " + clas);
    con = findMostSpecificConstructor(types, constructors);
    if (con == null)
        throw cantFindConstructor(clas, types);
    if (!isPublic(con))
        try {
            ReflectManager.RMSetAccessible(con);
        } catch (UtilEvalError /*ignore*/
        e) {
        }
    args = Primitive.unwrap(args);
    try {
        obj = con.newInstance(args);
    } catch (InstantiationException e) {
        throw new ReflectError("The class " + clas + " is abstract ");
    } catch (IllegalAccessException e) {
        throw new ReflectError("We don't have permission to create an instance." + "Use setAccessibility(true) to enable access.");
    } catch (IllegalArgumentException e) {
        throw new ReflectError("The number of arguments was wrong");
    }
    if (obj == null)
        throw new ReflectError("Couldn't construct the object");
    return obj;
}