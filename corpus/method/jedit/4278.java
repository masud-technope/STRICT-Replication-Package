//}}}
//{{{ listConfirm() method
/**
	 * Displays a confirm dialog box and returns the button pushed by the
	 * user. The title of the dialog is fetched from the
	 * <code><i>name</i>.title</code> property. The message is fetched
	 * from the <code><i>name</i>.message</code> property. The dialog
	 * also shows a list of entries given by the <code>listModel</code>
	 * parameter.
	 * @param comp the parent component
	 * @param name the name of the confirm dialog
	 * @param args the for the message
	 * @param listModel the items in the list
	 * @param selectedItems give an empty list, it will contains in return the selected items
	 * @return an integer indicating the option selected by the user
	 * @since jEdit 4.3pre12
	 */
@SuppressWarnings({ "unchecked" })
public static int listConfirm(final Component comp, final String name, final String[] args, final Object[] listModel, final List selectedItems) {
    if (EventQueue.isDispatchThread()) {
        JList<Object> list = new JList<Object>(listModel);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setVisibleRowCount(8);
        list.addSelectionInterval(0, listModel.length - 1);
        Object[] message = { jEdit.getProperty(name + ".message", args), new JScrollPane(list) };
        int ret = JOptionPane.showConfirmDialog(comp, message, jEdit.getProperty(name + ".title"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        selectedItems.addAll(list.getSelectedValuesList());
        return ret;
    }
    final int[] retValue = new int[1];
    try {
        EventQueue.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                retValue[0] = listConfirm(comp, name, args, listModel, selectedItems);
            }
        });
    } catch (Exception e) {
        return JOptionPane.CANCEL_OPTION;
    }
    return retValue[0];
}