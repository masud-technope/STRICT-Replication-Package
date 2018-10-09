//}}}
//{{{ getMouseOverText() method
/**
	 * @return the action's mouse over message. This returns the
	 * value of the property named by {@link #getName()} suffixed
	 * with <code>.mouse-over</code>.
	 */
public final String getMouseOverText() {
    return jEdit.getProperty(name + ".mouse-over");
}