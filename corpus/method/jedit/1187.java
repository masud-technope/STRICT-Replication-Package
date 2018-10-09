/**
		Get the static bsh namespace field from the class.
		@param className may be the name of clas itself or a superclass of clas.
	*/
static This getClassStaticThis(Class clas, String className) {
    try {
        return (This) Reflect.getStaticFieldValue(clas, BSHSTATIC + className);
    } catch (Exception e) {
        throw new InterpreterError("Unable to get class static space: " + e);
    }
}