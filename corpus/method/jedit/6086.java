/**
	 * Sets the specified register.
	 * @param name The name
	 * @param transferable the transferable
	 */
public static void setRegister(char name, Transferable transferable) {
    touchRegister(name);
    Register register = getRegister(name);
    if (register != null) {
        register.setTransferable(transferable);
        if (listener != null)
            listener.registerChanged(name);
    } else {
        Register defaultRegister = new DefaultRegister();
        defaultRegister.setTransferable(transferable);
        setRegister(name, defaultRegister);
    }
}