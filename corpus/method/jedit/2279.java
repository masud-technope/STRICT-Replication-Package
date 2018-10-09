/**
	*/
public static Object getObjectFieldValue(Object object, String fieldName) throws UtilEvalError, ReflectError {
    if (object instanceof This)
        return ((This) object).namespace.getVariable(fieldName);
    else {
        try {
            return getFieldValue(object.getClass(), object, /*onlystatic*/
            fieldName, false);
        } catch (ReflectError e) {
            if (hasObjectPropertyGetter(object.getClass(), fieldName))
                return getObjectProperty(object, fieldName);
            else
                throw e;
        }
    }
}