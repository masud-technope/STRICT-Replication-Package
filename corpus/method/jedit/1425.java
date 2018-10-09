/**
		Set strict Java mode on or off.
		This mode attempts to make BeanShell syntax behave as Java
		syntax, eliminating conveniences like loose variables, etc.
		When enabled, variables are required to be declared or initialized
		before use and method arguments are reqired to have types.
		<p>

		This mode will become more strict in a future release when
		classes are interpreted and there is an alternative to scripting
		objects as method closures.
	*/
public void setStrictJava(boolean b) {
    this.strictJava = b;
}