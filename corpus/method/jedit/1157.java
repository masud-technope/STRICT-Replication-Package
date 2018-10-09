/**
		zero based.
	*/
public NameSpace get(int depth) {
    if (depth >= depth())
        return NameSpace.JAVACODE;
    else
        return (NameSpace) (stack.elementAt(depth));
}