//}}}
//{{{ createPopupMenu() method
/**
	 * Creates the popup menu.
	 * @since 4.3pre15
	 */
@Override
public void createPopupMenu(MouseEvent evt) {
    popup = GUIUtilities.loadPopupMenu("view.context", this, evt);
    if (!jEdit.getBooleanProperty("options.context.includeOptionsLink"))
        return;
    JMenuItem customize = new JMenuItem(jEdit.getProperty("view.context.customize"));
    customize.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
            new GlobalOptions(view, "context");
        }
    });
    popup.addSeparator();
    popup.add(customize);
}