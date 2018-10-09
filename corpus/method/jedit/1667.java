/**
        Dissallow static vars outside of a class
        @param name is here just to allow the error message to use it
    protected void checkVariableModifiers( String name, Modifiers modifiers )
        throws UtilEvalError
    {
        if ( modifiers!=null && modifiers.hasModifier("static") )
            throw new UtilEvalError(
                "Can't declare static variable outside of class: "+name );
    }
    */
/**
        Note: this is primarily for internal use.
        @see Interpreter#source( String )
        @see Interpreter#eval( String )
    */
public void setMethod(String name, BshMethod method) throws UtilEvalError {
    if (methods == null)
        methods = new Hashtable();
    Object m = methods.get(name);
    //{{{ jEdit version: properly handle methods with same signature.
    if (m == null)
        methods.put(name, method);
    else if (m instanceof BshMethod) {
        // is the new method overriding the old method?
        if (Arrays.equals(((BshMethod) m).getParameterTypes(), method.getParameterTypes())) {
            methods.put(name, method);
        } else {
            Vector v = new Vector();
            v.addElement(m);
            v.addElement(method);
            methods.put(name, v);
        }
    } else {
        Vector _methods = (Vector) m;
        for (int i = 0; i < _methods.size(); i++) {
            // Check whether the new method overrides some old
            // method in the list.
            BshMethod _old_m = (BshMethod) _methods.get(i);
            if (Arrays.equals(_old_m.getParameterTypes(), method.getParameterTypes())) {
                _methods.remove(i);
                break;
            }
        }
        _methods.addElement(method);
    }
//}}}
//{{{ Original BeanShell code
// if ( m == null )
// 	methods.put(name, method);
// else
// if ( m instanceof BshMethod ) {
// 	Vector v = new Vector();
// 	v.addElement( m );
// 	v.addElement( method );
// 	methods.put( name, v );
// } else // Vector
// 	((Vector)m).addElement( method );
//}}}
}