/**
        Spawn a non-interactive local interpreter to evaluate text in the
		specified namespace.

		Return value is the evaluated object (or corresponding primitive
		wrapper).

		@param sourceFileInfo is for information purposes only.  It is used to
		display error messages (and in the future may be made available to
		the script).
		@throws EvalError on script problems
		@throws TargetError on unhandled exceptions from the script
    */
/*
		Note: we need a form of eval that passes the callstack through...
	*/
/*
	Can't this be combined with run() ?
	run seems to have stuff in it for interactive vs. non-interactive...
	compare them side by side and see what they do differently, aside from the
	exception handling.
	*/
public Object eval(Reader in, NameSpace nameSpace, String sourceFileInfo) throws /*, CallStack callstack */
EvalError {
    Object retVal = null;
    if (Interpreter.DEBUG)
        debug("eval: nameSpace = " + nameSpace);
    /*
			Create non-interactive local interpreter for this namespace
			with source from the input stream and out/err same as
			this interpreter.
		*/
    Interpreter localInterpreter = new Interpreter(in, out, err, false, nameSpace, this, sourceFileInfo);
    CallStack callstack = new CallStack(nameSpace);
    boolean eof = false;
    while (!eof) {
        SimpleNode node = null;
        try {
            eof = localInterpreter.Line();
            if (localInterpreter.get_jjtree().nodeArity() > 0) {
                node = (SimpleNode) localInterpreter.get_jjtree().rootNode();
                // nodes remember from where they were sourced
                node.setSourceFile(sourceFileInfo);
                if (TRACE)
                    println("// " + node.getText());
                retVal = node.eval(callstack, localInterpreter);
                // sanity check during development
                if (callstack.depth() > 1)
                    throw new InterpreterError("Callstack growing: " + callstack);
                if (retVal instanceof ReturnControl) {
                    retVal = ((ReturnControl) retVal).value;
                    // non-interactive, return control now
                    break;
                }
                if (localInterpreter.showResults && retVal != Primitive.VOID)
                    println("<" + retVal + ">");
            }
        } catch (ParseException e) {
            if (DEBUG)
                error(e.getMessage(DEBUG));
            e.setErrorSourceFile(sourceFileInfo);
            throw e;
        } catch (InterpreterError e) {
            e.printStackTrace();
            throw new EvalError("Sourced file: " + sourceFileInfo + " internal Error: " + e.getMessage(), node, callstack);
        } catch (TargetError e) {
            if (e.getNode() == null)
                e.setNode(node);
            e.reThrow("Sourced file: " + sourceFileInfo);
        } catch (EvalError e) {
            if (DEBUG)
                e.printStackTrace();
            if (e.getNode() == null)
                e.setNode(node);
            e.reThrow("Sourced file: " + sourceFileInfo);
        } catch (Exception e) {
            if (DEBUG)
                e.printStackTrace();
            throw new EvalError("Sourced file: " + sourceFileInfo + " unknown error: " + e.getMessage(), node, callstack);
        } catch (TokenMgrError e) {
            throw new EvalError("Sourced file: " + sourceFileInfo + " Token Parsing Error: " + e.getMessage(), node, callstack);
        } finally {
            localInterpreter.get_jjtree().reset();
            // reinit the callstack
            if (callstack.depth() > 1) {
                callstack.clear();
                callstack.push(nameSpace);
            }
        }
    }
    return Primitive.unwrap(retVal);
}