/**
		Get the prompt string defined by the getBshPrompt() method in the
		global namespace.  This may be from the getBshPrompt() command or may
		be defined by the user as with any other method.
		Defaults to "bsh % " if the method is not defined or there is an error.
	*/
private String getBshPrompt() {
    try {
        return (String) eval("getBshPrompt()");
    } catch (Exception e) {
        return "bsh % ";
    }
}