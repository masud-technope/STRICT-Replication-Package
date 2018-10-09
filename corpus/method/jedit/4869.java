//}}}
//{{{ getRegisterStatusPrompt() method
/**
	 * Returns the status prompt for the given register action. Only
	 * intended to be called from <code>actions.xml</code>.
	 * @since jEdit 4.3pre16
	 */
public static String getRegisterStatusPrompt(String action) {
    String registerNameString = Registers.getRegisterNameString();
    return jEdit.getProperty("view.status." + action, new String[] { registerNameString == null ? jEdit.getProperty("view.status.no-registers") : registerNameString });
}