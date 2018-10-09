//}}}
//{{{ applyTextAreaColors() method
/**
	 * experimental - applies the text area colors on a Component
	 * (such as a dockable window) and its children.
	 * @since jEdit 5.0pre1
	 * @author ezust
	 *
	 */
public static void applyTextAreaColors(Container win) {
    for (Component child : win.getComponents()) {
        child.setBackground(jEdit.getColorProperty("view.bgColor", Color.WHITE));
        child.setForeground(jEdit.getColorProperty("view.fgColor", Color.BLACK));
        if (child instanceof JTextPane)
            ((JTextPane) child).setUI(new javax.swing.plaf.basic.BasicEditorPaneUI());
        if (child instanceof Container)
            applyTextAreaColors((Container) child);
    }
}