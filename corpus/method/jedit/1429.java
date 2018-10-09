/**
		Construct a new interactive interpreter attached to the specified
		console using the specified parent namespace.
	*/
public  Interpreter(ConsoleInterface console, NameSpace globalNameSpace) {
    this(console.getIn(), console.getOut(), console.getErr(), true, globalNameSpace);
    setConsole(console);
}