// End constructors
/**
		Attach a console
		Note: this method is incomplete.
	*/
public void setConsole(ConsoleInterface console) {
    this.console = console;
    setu("bsh.console", console);
    // redundant with constructor
    setOut(console.getOut());
    setErr(console.getErr());
// need to set the input stream - reinit the parser?
}