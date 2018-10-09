//{{{ JEditSwingTrayIcon() constructor
public  JEditSwingTrayIcon() {
    super(GUIUtilities.getEditorIcon(), "jEdit");
    setImageAutoSize(true);
    JPopupMenu popup = new JPopupMenu();
    JMenuItem newViewItem = new JMenuItem(jEdit.getProperty("tray.newView.label"));
    JMenuItem newPlainViewItem = new JMenuItem(jEdit.getProperty("tray.newPlainView.label"));
    JMenuItem exitItem = new JMenuItem(jEdit.getProperty("tray.exit.label"));
    popup.add(newViewItem);
    popup.add(newPlainViewItem);
    popup.addSeparator();
    popup.add(exitItem);
    ActionListener actionListener = new MyActionListener(newViewItem, newPlainViewItem, exitItem);
    newViewItem.addActionListener(actionListener);
    newPlainViewItem.addActionListener(actionListener);
    exitItem.addActionListener(actionListener);
    setMenu(popup);
    addMouseListener(new MyMouseAdapter());
}