//}}}
//{{{ getToolTip() method
/**
	 * @return the action's tooltip text. This returns the
	 * value of the property named by {@link #getName()} suffixed
	 * with <code>.tooltip</code>.
	 */
public String getToolTip() {
    return jEdit.getProperty(name + ".tooltip");
}