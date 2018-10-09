//}}}
//{{{ getRegisterNameString() method
/**
	 * Returns a string of all defined registers, used by the status bar
	 * (eg, "a b $ % ^").
	 * @since jEdit 4.2pre2
	 */
public static String getRegisterNameString() {
    if (!loaded)
        loadRegisters();
    StringBuilder buf = new StringBuilder(registers.length << 1);
    for (int i = 0; i < registers.length; i++) {
        if (registers[i] != null) {
            if (buf.length() != 0)
                buf.append(' ');
            buf.append((char) i);
        }
    }
    if (buf.length() == 0)
        return null;
    else
        return buf.toString();
}