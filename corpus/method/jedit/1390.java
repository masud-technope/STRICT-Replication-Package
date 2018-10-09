// end source and eval
/**
		Print an error message in a standard format on the output stream
		associated with this interpreter. On the GUI console this will appear
		in red, etc.
	*/
public final void error(Object o) {
    if (console != null)
        console.error("// Error: " + o + "\n");
    else {
        err.println("// Error: " + o);
        err.flush();
    }
}