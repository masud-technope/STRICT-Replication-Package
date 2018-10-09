//}}}
//{{{ loadToolButton() method
/**
	 * Loads a tool bar button. The tooltip is constructed from
	 * the <code><i>name</i>.label</code> and
	 * <code><i>name</i>.shortcut</code> properties and the icon is loaded
	 * from the resource named '/org/gjt/sp/jedit/icons/' suffixed
	 * with the value of the <code><i>name</i>.icon</code> property.
	 * @param context An action context; either
	 * <code>jEdit.getActionContext()</code> or
	 * <code>VFSBrowser.getActionContext()</code>.
	 * @param name The name of the button
	 * @return the button
	 * @since jEdit 4.2pre1
	 */
public static EnhancedButton loadToolButton(ActionContext context, String name) {
    String label = jEdit.getProperty(name + ".label");
    if (label == null)
        label = name;
    Icon icon;
    String iconName = jEdit.getProperty(name + ".icon");
    if (iconName == null)
        icon = loadIcon(jEdit.getProperty("broken-image.icon"));
    else {
        icon = loadIcon(iconName);
        if (icon == null)
            icon = loadIcon(jEdit.getProperty("broken-image.icon"));
    }
    String toolTip = GenericGUIUtilities.prettifyMenuLabel(label);
    String shortcutLabel = getShortcutLabel(name, true);
    if (shortcutLabel != null) {
        toolTip = toolTip + " (" + shortcutLabel + ')';
    }
    EnhancedButton b = new EnhancedButton(icon, toolTip, name, context);
    b.setPreferredSize(new Dimension(32, 32));
    return b;
}