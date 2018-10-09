@Override
public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == add) {
        ContextAddDialog dialog = new ContextAddDialog(AbstractContextOptionPane.this, actionContext);
        String selection = dialog.getSelection();
        if (selection == null)
            return;
        int index = list.getSelectedIndex();
        if (index == -1)
            index = listModel.getSize();
        else
            index++;
        MenuItem menuItem;
        if (selection.equals("-"))
            menuItem = new AbstractContextOptionPane.MenuItem("-", "-");
        else {
            EditAction action = actionContext.getAction(selection);
            String label = action.getLabel();
            menuItem = new AbstractContextOptionPane.MenuItem(selection, label);
        }
        listModel.insertElementAt(menuItem, index);
        list.setSelectedIndex(index);
        list.ensureIndexIsVisible(index);
    } else if (source == remove) {
        int index = list.getSelectedIndex();
        listModel.removeElementAt(index);
        if (listModel.getSize() != 0) {
            list.setSelectedIndex(Math.min(listModel.getSize() - 1, index));
        }
        updateButtons();
    } else if (source == moveUp) {
        int index = list.getSelectedIndex();
        MenuItem selected = (MenuItem) list.getSelectedValue();
        listModel.removeElementAt(index);
        listModel.insertElementAt(selected, index - 1);
        list.setSelectedIndex(index - 1);
        list.ensureIndexIsVisible(index - 1);
    } else if (source == moveDown) {
        int index = list.getSelectedIndex();
        MenuItem selected = (MenuItem) list.getSelectedValue();
        listModel.removeElementAt(index);
        listModel.insertElementAt(selected, index + 1);
        list.setSelectedIndex(index + 1);
        list.ensureIndexIsVisible(index + 1);
    } else if (source == reset) {
        String dialogType = "options.context.reset.dialog";
        int result = GUIUtilities.confirm(list, dialogType, null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            // the user should be able to cancel the options dialog 
            // so we need to modify the list, not the actual property
            // since the default value is not available, 
            // we reset, fetch default value and re-set to original
            String orgContext = jEdit.getProperty("view.context");
            jEdit.resetProperty("view.context");
            String defaultContext = jEdit.getProperty("view.context");
            jEdit.setProperty("view.context", orgContext);
            reloadContextList(defaultContext);
            // reset selection if user had more buttons than default
            list.setSelectedIndex(0);
            list.ensureIndexIsVisible(0);
            updateButtons();
        }
    }
}