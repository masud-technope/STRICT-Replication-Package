//}}}
//{{{ loadPopupMenu() method
/**
	 * Creates a popup menu.
	 * @param name The menu name
	 * @param evt mouse event
	 * @param textArea the text area
	 * @return a popup menu
	 * @since jEdit 2.6pre2
	 */
public static JPopupMenu loadPopupMenu(String name, JEditTextArea textArea, MouseEvent evt) {
    return loadPopupMenu(jEdit.getActionContext(), name, textArea, evt);
}