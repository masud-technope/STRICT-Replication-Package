// ConsoleInterface
// The interpreter reflexively implements the console interface that it
// uses.  Should clean this up by using an inner class to implement the
// console for us.
/**
		Get the input stream associated with this interpreter.
		This may be be stdin or the GUI console.
	*/
public Reader getIn() {
    return in;
}