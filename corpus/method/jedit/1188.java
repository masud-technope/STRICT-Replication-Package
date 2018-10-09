/**
		Get the instance bsh namespace field from the object instance.
		@return the class instance This object or null if the object has not
		been initialized.
	*/
static This getClassInstanceThis(Object instance, String className) {
    try {
        Object o = Reflect.getObjectFieldValue(instance, BSHTHIS + className);
        // unwrap Primitive.Null to null
        return (This) Primitive.unwrap(o);
    } catch (Exception e) {
        throw new InterpreterError("Generated class: Error getting This" + e);
    }
}