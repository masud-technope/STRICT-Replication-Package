/**
	 * Sets the specified register.
	 * @param name The name
	 * @param value The new value
	 */
public static void setRegister(char name, String value) {
    setRegister(name, new StringSelection(value));
}