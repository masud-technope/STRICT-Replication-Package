//}}}
//{{{ getLabel() method
/**
	 * @return the action's label. This returns the
	 * value of the property named by {@link #getName()} suffixed
	 * with <code>.label</code>.
	 * 
	 */
public String getLabel() {
    if (args != null) {
        return jEdit.getProperty(name + ".label", args);
    }
    return jEdit.getProperty(name + ".label");
}