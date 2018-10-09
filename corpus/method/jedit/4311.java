//}}}
//{{{ loadToolBar() method
/**
	 * Creates a toolbar.
	 * @param context An action context; either
	 * <code>jEdit.getActionContext()</code> or
	 * <code>VFSBrowser.getActionContext()</code>.
	 * @param name The toolbar name
	 * @return the toolbar
	 * @since jEdit 4.2pre2
	 */
public static Container loadToolBar(ActionContext context, String name) {
    JToolBar toolB = new JToolBar();
    toolB.setName(name);
    toolB.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    toolB.setFloatable(jEdit.getBooleanProperty("view.toolbar.floatable"));
    String buttons = jEdit.getProperty(name);
    if (buttons != null) {
        StringTokenizer st = new StringTokenizer(buttons);
        while (st.hasMoreTokens()) {
            String button = st.nextToken();
            if ("-".equals(button)) {
                toolB.addSeparator(new Dimension(12, 12));
            } else {
                JButton b = loadToolButton(context, button);
                if (b != null)
                    toolB.add(b);
            }
        }
    }
    toolB.addSeparator(new Dimension(12, 12));
    return toolB;
}