public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == add) {
        ToolBarEditDialog dialog = new ToolBarEditDialog(ToolBarOptionPane.this, iconList, null);
        Button selection = dialog.getSelection();
        if (selection == null)
            return;
        int index = list.getSelectedIndex();
        if (index == -1)
            index = listModel.getSize();
        else
            index++;
        listModel.insertElementAt(selection, index);
        list.setSelectedIndex(index);
        list.ensureIndexIsVisible(index);
    } else if (source == remove) {
        int index = list.getSelectedIndex();
        listModel.removeElementAt(index);
        if (listModel.getSize() != 0) {
            if (listModel.getSize() == index)
                list.setSelectedIndex(index - 1);
            else
                list.setSelectedIndex(index);
        }
        updateButtons();
    } else if (source == moveUp) {
        int index = list.getSelectedIndex();
        Button selected = (Button) list.getSelectedValue();
        listModel.removeElementAt(index);
        listModel.insertElementAt(selected, index - 1);
        list.setSelectedIndex(index - 1);
        list.ensureIndexIsVisible(index - 1);
    } else if (source == moveDown) {
        int index = list.getSelectedIndex();
        Button selected = (Button) list.getSelectedValue();
        listModel.removeElementAt(index);
        listModel.insertElementAt(selected, index + 1);
        list.setSelectedIndex(index + 1);
        list.ensureIndexIsVisible(index + 1);
    } else if (source == edit) {
        ToolBarEditDialog dialog = new ToolBarEditDialog(ToolBarOptionPane.this, iconList, (Button) list.getSelectedValue());
        Button selection = dialog.getSelection();
        if (selection == null)
            return;
        int index = list.getSelectedIndex();
        listModel.setElementAt(selection, index);
        list.setSelectedIndex(index);
        list.ensureIndexIsVisible(index);
    } else if (source == reset) {
        String dialogType = "options.toolbar.reset.dialog";
        int result = GUIUtilities.confirm(list, dialogType, null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            // the user should be able to cancel the options dialog
            // so we need to modify the list, not the actual property
            // since the default value is not available,
            // we reset, fetch default value and re-set to original
            String orgToolbar = jEdit.getProperty("view.toolbar");
            jEdit.resetProperty("view.toolbar");
            String defaultToolbar = jEdit.getProperty("view.toolbar");
            jEdit.setProperty("view.toolbar", orgToolbar);
            reloadButtonList(defaultToolbar);
            // reset selection if user had more buttons than default
            list.setSelectedIndex(0);
            list.ensureIndexIsVisible(0);
            updateButtons();
        }
    }
}