/*
		Note: we could override this method to allow bsh methods to appear in
		the external map.
	*/
public void setMethod(String name, BshMethod method) throws UtilEvalError {
    super.setMethod(name, method);
}