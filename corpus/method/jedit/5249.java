/**
	 * Creates an option group.
	 * @param name The internal name of the option group, used to key a
	 * property <code>options.<i>name</i>.label</code> which is the
	 * label displayed in the options dialog.
	 * @see jEdit#getProperty(String)
	 */
public  OptionGroup(String name) {
    this.name = name;
    label = jEdit.getProperty("options." + name + ".label");
    members = new Vector<Object>();
}