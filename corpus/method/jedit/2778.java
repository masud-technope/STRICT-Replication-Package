//}}}
//{{{ toggleAutoIndent() method
/**
	 * Toggles automatic indentation on and off.
	 * @param view This view's status bar will display the message
	 * @since jEdit 5.0
	 */
public void toggleAutoIndent(View view) {
    String indent = getStringProperty("autoIndent");
    if (indent.equals("none"))
        indent = "simple";
    else if (indent.equals("simple"))
        indent = "full";
    else if (indent.equals("full"))
        indent = "none";
    setProperty("autoIndent", indent);
    view.getStatus().setMessageAndClear(jEdit.getProperty("view.status.autoindent-changed", new String[] { indent }));
}