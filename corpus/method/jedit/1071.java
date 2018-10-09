/**
		Get the return type of the method.
		@return Returns null for a loosely typed return value, 
			Void.TYPE for a void return type, or the Class of the type.
	*/
/*
		Note: bshmethod needs to re-evaluate the method return type here.
		This is broken.
	*/
public Class getReturnType() {
    return creturnType;
}