/**
		De-serialization setup.
		Default out and err streams to stdout, stderr if they are null.
	*/
private void readObject(ObjectInputStream stream) throws java.io.IOException, ClassNotFoundException {
    stream.defaultReadObject();
    // set transient fields
    if (console != null) {
        setOut(console.getOut());
        setErr(console.getErr());
    } else {
        setOut(System.out);
        setErr(System.err);
    }
}