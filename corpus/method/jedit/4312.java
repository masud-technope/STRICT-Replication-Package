//}}}
//{{{ loadToolBar() method
/**
	 * @return a toolbar.
	 * @param name The toolbar name
	 * @since jEdit 4.2pre2
	 */
public static Container loadToolBar(String name) {
    return loadToolBar(jEdit.getActionContext(), name);
}