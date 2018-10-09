/**
		Create an interpreter for evaluation only.
	*/
public  Interpreter() {
    this(new StringReader(""), System.out, System.err, false, null);
    evalOnly = true;
    setu("bsh.evalOnly", new Primitive(true));
}