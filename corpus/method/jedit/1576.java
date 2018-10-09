/**
		@param localVar if true the variable is set directly in the This
		reference's local scope.  If false recursion to look for the variable
		definition in parent's scope is allowed. (e.g. the default case for
		undefined vars going to global).
	*/
 LHS(NameSpace nameSpace, String varName, boolean localVar) {
    type = VARIABLE;
    this.localVar = localVar;
    this.varName = varName;
    this.nameSpace = nameSpace;
}