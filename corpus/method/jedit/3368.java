/**
		 * @return A label appropriate for the title on the dock buttons.
		 */
public String label() {
    String retval = jEdit.getProperty(factory.name + ".label");
    retval = retval.replaceAll("\\$", "");
    return retval;
}