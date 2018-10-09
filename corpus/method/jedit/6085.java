//}}}
//{{{ getRegister() method
/**
	 * Returns the specified register.
	 * @param name The name
	 */
public static Register getRegister(char name) {
    if (name != '$' && name != '%') {
        if (!loaded)
            loadRegisters();
    }
    if (registers == null || name >= registers.length)
        return null;
    else
        return registers[name];
}