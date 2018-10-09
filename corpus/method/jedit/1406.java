/**
		Run interactively.  (printing prompts, etc.)
	*/
public void run() {
    if (evalOnly)
        throw new RuntimeException("bsh Interpreter: No stream");
    /*
          We'll print our banner using eval(String) in order to
          exercise the parser and get the basic expression classes loaded...
          This ameliorates the delay after typing the first statement.
        */
    if (interactive)
        try {
            eval("printBanner();");
        } catch (EvalError e) {
            println("BeanShell " + VERSION + " - by Pat Niemeyer (pat@pat.net)");
        }
    // init the callstack.
    CallStack callstack = new CallStack(globalNameSpace);
    boolean eof = false;
    while (!eof) {
        try {
            // try to sync up the console
            System.out.flush();
            System.err.flush();
            // this helps a little
            Thread.yield();
            if (interactive)
                print(getBshPrompt());
            eof = Line();
            if (// number of child nodes
            get_jjtree().nodeArity() > 0) {
                SimpleNode node = (SimpleNode) (get_jjtree().rootNode());
                if (DEBUG)
                    node.dump(">");
                Object ret = node.eval(callstack, this);
                // sanity check during development
                if (callstack.depth() > 1)
                    throw new InterpreterError("Callstack growing: " + callstack);
                if (ret instanceof ReturnControl)
                    ret = ((ReturnControl) ret).value;
                if (ret != Primitive.VOID) {
                    setu("$_", ret);
                    if (showResults)
                        println("<" + ret + ">");
                }
            }
        } catch (ParseException e) {
            error("Parser Error: " + e.getMessage(DEBUG));
            if (DEBUG)
                e.printStackTrace();
            if (!interactive)
                eof = true;
            parser.reInitInput(in);
        } catch (InterpreterError e) {
            error("Internal Error: " + e.getMessage());
            e.printStackTrace();
            if (!interactive)
                eof = true;
        } catch (TargetError e) {
            error("// Uncaught Exception: " + e);
            if (e.inNativeCode())
                e.printStackTrace(DEBUG, err);
            if (!interactive)
                eof = true;
            setu("$_e", e.getTarget());
        } catch (EvalError e) {
            if (interactive)
                error("EvalError: " + e.toString());
            else
                error("EvalError: " + e.getMessage());
            if (DEBUG)
                e.printStackTrace();
            if (!interactive)
                eof = true;
        } catch (Exception e) {
            error("Unknown error: " + e);
            if (DEBUG)
                e.printStackTrace();
            if (!interactive)
                eof = true;
        } catch (TokenMgrError e) {
            error("Error parsing input: " + e);
            parser.reInitTokenInput(in);
            if (!interactive)
                eof = true;
        } finally {
            get_jjtree().reset();
            // reinit the callstack
            if (callstack.depth() > 1) {
                callstack.clear();
                callstack.push(globalNameSpace);
            }
        }
    }
    if (interactive && exitOnEOF)
        System.exit(0);
}