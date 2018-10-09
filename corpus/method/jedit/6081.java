//}}}
//{{{ getRegisters() method
/**
	 * Returns an array of all available registers. Some of the elements
	 * of this array might be <code>null</code>.
	 */
public static Register[] getRegisters() {
    if (!loaded)
        loadRegisters();
    return registers;
}