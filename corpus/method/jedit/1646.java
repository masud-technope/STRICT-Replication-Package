/**
        Get the parent namespace' This reference or this namespace' This
        reference if we are the top.
    */
public This getSuper(Interpreter declaringInterpreter) {
    if (parent != null)
        return parent.getThis(declaringInterpreter);
    else
        return getThis(declaringInterpreter);
}