package org.gjt.sp.jedit.bsh;

import java.util.*;

/*
	Implementation notes:  bsh methods are not currently expored to the
	external namespace.  All that would be required to add this is to override
	setMethod() and provide a friendlier view than vector (currently used) for
	overloaded forms (perhaps a map by method SignatureKey).
*/
@SuppressWarnings("unchecked")
public class ExternalNameSpace extends NameSpace {

    private Map externalMap;

    public  ExternalNameSpace() {
        this(null, "External Map Namespace", null);
    }

    /**
	*/
    public  ExternalNameSpace(NameSpace parent, String name, Map externalMap) {
        super(parent, name);
        if (externalMap == null)
            externalMap = new HashMap();
        this.externalMap = externalMap;
    }

    /**
		Get the map view of this namespace.
	*/
    public Map getMap() {
        return externalMap;
    }

    /**
		Set the external Map which to which this namespace synchronizes.
		The previous external map is detached from this namespace.  Previous
		map values are retained in the external map, but are removed from the
		BeanShell namespace.
	*/
    public void setMap(Map map) {
        // Detach any existing namespace to preserve it, then clear this
        // namespace and set the new one
        this.externalMap = null;
        clear();
        this.externalMap = map;
    }

    /**
	*/
    void setVariable(String name, Object value, boolean strictJava, boolean recurse) throws UtilEvalError {
        super.setVariable(name, value, strictJava, recurse);
        putExternalMap(name, value);
    }

    /**
	*/
    public void unsetVariable(String name) {
        super.unsetVariable(name);
        externalMap.remove(name);
    }

    /**
	*/
    public String[] getVariableNames() {
        // union of the names in the internal namespace and external map
        Set nameSet = new HashSet();
        String[] nsNames = super.getVariableNames();
        nameSet.addAll(Arrays.asList(nsNames));
        nameSet.addAll(externalMap.keySet());
        return (String[]) nameSet.toArray(new String[0]);
    }

    /*
		Notes: This implmenetation of getVariableImpl handles the following
		cases:
		1) var in map not in local scope - var was added through map
		2) var in map and in local scope - var was added through namespace
		3) var not in map but in local scope - var was removed via map
		4) var not in map and not in local scope - non-existent var
	*/
    protected Variable getVariableImpl(String name, boolean recurse) throws UtilEvalError {
        // check the external map for the variable name
        Object value = externalMap.get(name);
        Variable var;
        if (value == null) {
            // The var is not in external map and it should therefore not be
            // found in local scope (it may have been removed via the map).  
            // Clear it prophalactically.
            super.unsetVariable(name);
            // Search parent for var if applicable.
            var = super.getVariableImpl(name, recurse);
        } else {
            // Var in external map may be found in local scope with type and
            // modifier info.
            Variable localVar = super.getVariableImpl(name, false);
            // version.
            if (localVar == null)
                var = new Variable(name, (Class) null, value, (Modifiers) null);
            else
                var = localVar;
        }
        return var;
    }

    /*
		Note: the meaning of getDeclaredVariables() is not entirely clear, but
		the name (and current usage in class generation support) suggests that
		untyped variables should not be inclueded.  Therefore we do not
		currently have to add the external names here.
	*/
    public Variable[] getDeclaredVariables() {
        return super.getDeclaredVariables();
    }

    /**
    */
    public void setTypedVariable(String name, Class type, Object value, Modifiers modifiers) throws UtilEvalError {
        super.setTypedVariable(name, type, value, modifiers);
        putExternalMap(name, value);
    }

    /*
		Note: we could override this method to allow bsh methods to appear in
		the external map.
	*/
    public void setMethod(String name, BshMethod method) throws UtilEvalError {
        super.setMethod(name, method);
    }

    /*
		Note: kind of far-fetched, but... we could override this method to
		allow bsh methods to be inserted into this namespace via the map.
	*/
    public BshMethod getMethod(String name, Class[] sig, boolean declaredOnly) throws UtilEvalError {
        return super.getMethod(name, sig, declaredOnly);
    }

    /*
		Note: this method should be overridden to add the names from the
		external map, as is done in getVariableNames();
	*/
    protected void getAllNamesAux(Vector vec) {
        super.getAllNamesAux(vec);
    }

    /**
		Clear all variables, methods, and imports from this namespace and clear
		all values from the external map (via Map clear()).
	*/
    public void clear() {
        super.clear();
        externalMap.clear();
    }

    /**
		Place an unwrapped value in the external map.
		BeanShell primitive types are represented by their object wrappers, so
		it is not possible to differentiate between wrapper types and primitive
		types via the external Map.
	*/
    protected void putExternalMap(String name, Object value) {
        if (value instanceof Variable)
            try {
                value = unwrapVariable((Variable) value);
            } catch (UtilEvalError ute) {
                throw new InterpreterError("unexpected UtilEvalError");
            }
        if (value instanceof Primitive)
            value = Primitive.unwrap((Primitive) value);
        externalMap.put(name, value);
    }
}
