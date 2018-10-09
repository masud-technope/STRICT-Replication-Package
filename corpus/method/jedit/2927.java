//}}}
//{{{ isToggle() method
/**
	 * @return if this edit action should be displayed as a check box
	 * in menus. This returns the
	 * value of the property named by {@link #getName()} suffixed
	 * with <code>.toggle</code>.
	 *
	 * @since jEdit 2.2pre4
	 */
public final boolean isToggle() {
    return jEdit.getBooleanProperty(name + ".toggle");
}