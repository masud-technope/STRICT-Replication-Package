/**
		Assign a value to the LHS.
	*/
public Object assign(Object val, boolean strictJava) throws UtilEvalError {
    if (type == VARIABLE) {
        // Set the variable in namespace according to localVar flag
        if (localVar)
            nameSpace.setLocalVariable(varName, val, strictJava);
        else
            nameSpace.setVariable(varName, val, strictJava);
    } else if (type == FIELD) {
        try {
            Object fieldVal = val instanceof Primitive ? ((Primitive) val).getValue() : val;
            // This should probably be in Reflect.java
            ReflectManager.RMSetAccessible(field);
            field.set(object, fieldVal);
            return val;
        } catch (NullPointerException e) {
            throw new UtilEvalError("LHS (" + field.getName() + ") not a static field.");
        } catch (IllegalAccessException e2) {
            throw new UtilEvalError("LHS (" + field.getName() + ") can't access field: " + e2);
        } catch (IllegalArgumentException e3) {
            String type = val instanceof Primitive ? ((Primitive) val).getType().getName() : val.getClass().getName();
            throw new UtilEvalError("Argument type mismatch. " + (val == null ? "null" : type) + " not assignable to field " + field.getName());
        }
    } else if (type == PROPERTY) {
        /*
			if ( object instanceof Hashtable )
				((Hashtable)object).put(propName, val);
			*/
        CollectionManager cm = CollectionManager.getCollectionManager();
        if (cm.isMap(object))
            cm.putInMap(/*map*/
            object, propName, val);
        else
            try {
                Reflect.setObjectProperty(object, propName, val);
            } catch (ReflectError e) {
                Interpreter.debug("Assignment: " + e.getMessage());
                throw new UtilEvalError("No such property: " + propName);
            }
    } else if (type == INDEX)
        try {
            Reflect.setIndex(object, index, val);
        } catch (UtilTargetError // pass along target error
        e1) {
            throw e1;
        } catch (Exception e) {
            throw new UtilEvalError("Assignment: " + e.getMessage());
        }
    else
        throw new InterpreterError("unknown lhs");
    return val;
}