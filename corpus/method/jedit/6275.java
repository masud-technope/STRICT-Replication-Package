//}}}
//{{{ setBeanShellReplace() method
/**
	 * Sets the state of the BeanShell replace flag.
	 * @param beanshell True if the replace string is a BeanShell expression
	 * @since jEdit 3.2pre2
	 */
public static void setBeanShellReplace(boolean beanshell) {
    if (beanshell == SearchAndReplace.beanshell)
        return;
    SearchAndReplace.beanshell = beanshell;
    EditBus.send(new SearchSettingsChanged(null));
}