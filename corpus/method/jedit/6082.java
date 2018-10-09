//}}}
//{{{ clearRegister() method
/**
	 * Sets the value of the specified register to <code>null</code>.
	 * @param name The register name
	 */
public static void clearRegister(char name) {
    if (name >= registers.length)
        return;
    Register register = registers[name];
    if (name == '$' || name == '%')
        register.setTransferable(new StringSelection(""));
    else {
        registers[name] = null;
        modified = true;
        if (listener != null)
            listener.registerChanged(name);
    }
}