// begin source and eval
/**
		Read text from fileName and eval it.
	*/
public Object source(String filename, NameSpace nameSpace) throws FileNotFoundException, IOException, EvalError {
    File file = pathToFile(filename);
    if (Interpreter.DEBUG)
        debug("Sourcing file: " + file);
    Reader sourceIn = new BufferedReader(new FileReader(file));
    try {
        return eval(sourceIn, nameSpace, filename);
    } finally {
        sourceIn.close();
    }
}