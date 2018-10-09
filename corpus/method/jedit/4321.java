//}}}
//{{{ loadToolButton() method
/**
	 * Loads a tool bar button. The tooltip is constructed from
	 * the <code><i>name</i>.label</code> and
	 * <code><i>name</i>.shortcut</code> properties and the icon is loaded
	 * from the resource named '/org/gjt/sp/jedit/icons/' suffixed
	 * with the value of the <code><i>name</i>.icon</code> property.
	 * @param name The name of the button
	 * @return a button
	 */
public static EnhancedButton loadToolButton(String name) {
    return loadToolButton(jEdit.getActionContext(), name);
}