/**
	 * Creates a new menu item. Most plugins should call
	 * GUIUtilities.loadMenuItem() instead.
	 * @param label The menu item label
	 * @param action The edit action
	 * @param context An action context
	 * @since jEdit 4.2pre1
	 */
public  EnhancedMenuItem(String label, String action, ActionContext context) {
    this.shortcut = GUIUtilities.getShortcutLabel(action, true);
    String toolTip = jEdit.getProperty(action + ".tooltip");
    if (toolTip != null) {
        setToolTipText(toolTip);
    }
    if (OperatingSystem.hasScreenMenuBar() && shortcut != null) {
        if (jEdit.getBooleanProperty("menu.multiShortcut", false)) {
            setText(label + " ( " + shortcut + " )");
        } else {
            setText(label);
            Keymap keymap = jEdit.getKeymapManager().getKeymap();
            String rawShortcut = keymap.getShortcut(action + ".shortcut");
            KeyStroke key = KeyEventTranslator.parseKeyStroke(rawShortcut);
            if (key != null)
                setAccelerator(key);
        }
        shortcut = null;
    } else
        setText(label);
    if (action != null) {
        setEnabled(true);
        addActionListener(new EditAction.Wrapper(context, action));
        addMouseListener(new HoverSetStatusMouseHandler(action));
    } else
        setEnabled(false);
}