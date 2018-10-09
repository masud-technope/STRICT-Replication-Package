/**
		Read text from fileName and eval it.
		Convenience method.  Use the global namespace.
	*/
public Object source(String filename) throws FileNotFoundException, IOException, EvalError {
    return source(filename, globalNameSpace);
}