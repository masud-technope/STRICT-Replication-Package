/*
		Note: kind of far-fetched, but... we could override this method to
		allow bsh methods to be inserted into this namespace via the map.
	*/
public BshMethod getMethod(String name, Class[] sig, boolean declaredOnly) throws UtilEvalError {
    return super.getMethod(name, sig, declaredOnly);
}