/**
		super is our parent's super
	*/
public This getSuper(Interpreter declaringInterpreter) {
    return getNonBlockParent().getSuper(declaringInterpreter);
}