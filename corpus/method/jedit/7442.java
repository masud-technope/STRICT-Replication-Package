//}}}
//{{{ showUserTitleDialog() method
/**
	 * Shows a dialog for selecting a user-defined title for this view.
	 */
public void showUserTitleDialog() {
    String title = JOptionPane.showInputDialog(this, jEdit.getProperty("view.title.select"));
    if (title == null)
        return;
    setUserTitle(title);
}