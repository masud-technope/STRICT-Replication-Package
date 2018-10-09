//  ---- BeanShell specific stuff hereafter ----  //
/**
		Detach this node from its parent.
		This is primarily useful in node serialization.
		(see BSHMethodDeclaration)
	*/
public void prune() {
    jjtSetParent(null);
}