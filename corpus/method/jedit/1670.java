/**
        @see #getMethod( String, Class [], boolean )
        @see #getMethod( String, Class [] )
    */
public BshMethod getMethod(String name, Class[] sig) throws UtilEvalError {
    return getMethod(name, sig, false);
}