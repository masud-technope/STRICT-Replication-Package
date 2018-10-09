/**
		Get the argument types of this method.
		loosely typed (untyped) arguments will be represented by null argument
		types.
	*/
/*
		Note: bshmethod needs to re-evaluate arg types here
		This is broken.
	*/
public Class[] getParameterTypes() {
    return cparamTypes;
}