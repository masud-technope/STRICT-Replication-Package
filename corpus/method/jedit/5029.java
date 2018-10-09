//}}}
//{{{ getMacro() method
/**
	 * Returns the macro with the specified name.
	 * @param macro The macro's name
	 * @since jEdit 2.6pre1
	 */
public static Macro getMacro(String macro) {
    return macroHash.get(macro);
}