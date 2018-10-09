//}}}
//{{{ setRegister() methods
/**
	 * Sets the specified register.
	 * @param name The name
	 * @param newRegister The new value
	 */
public static void setRegister(char name, Register newRegister) {
    touchRegister(name);
    if (name >= registers.length) {
        Register[] newRegisters = new Register[Math.min(1 << 16, name << 1)];
        System.arraycopy(registers, 0, newRegisters, 0, registers.length);
        registers = newRegisters;
    }
    registers[name] = newRegister;
    if (listener != null)
        listener.registerChanged(name);
}