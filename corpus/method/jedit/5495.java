@Override
public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == add) {
        WidgetSelectionDialog dialog = new WidgetSelectionDialog(StatusBarOptionPane.this);
        String value = dialog.getValue();
        if (value == null || value.isEmpty())
            return;
        int index = list.getSelectedIndex();
        if (index == -1)
            index = listModel.getSize();
        else
            index++;
        listModel.insertElementAt(value, index);
        list.setSelectedIndex(index);
        list.ensureIndexIsVisible(index);
        updatePreview();
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
        updatePreview();
    } else if (source == moveUp) {
        int index = list.getSelectedIndex();
        Object selected = list.getSelectedValue();
        listModel.removeElementAt(index);
        listModel.insertElementAt(selected.toString(), index - 1);
        list.setSelectedIndex(index - 1);
        list.ensureIndexIsVisible(index - 1);
        updatePreview();
    } else if (source == moveDown) {
        int index = list.getSelectedIndex();
        Object selected = list.getSelectedValue();
        listModel.removeElementAt(index);
        listModel.insertElementAt(selected.toString(), index + 1);
        list.setSelectedIndex(index + 1);
        list.ensureIndexIsVisible(index + 1);
        updatePreview();
    } else if (source == edit) {
        Object selectedValue = list.getSelectedValue();
        if (selectedValue == null)
            return;
        WidgetSelectionDialog dialog = new WidgetSelectionDialog(StatusBarOptionPane.this, String.valueOf(selectedValue));
        String value = dialog.getValue();
        if (value == null || value.isEmpty())
            return;
        int index = list.getSelectedIndex();
        listModel.remove(index);
        listModel.insertElementAt(value, index);
        list.setSelectedIndex(index);
        list.ensureIndexIsVisible(index);
        updatePreview();
    }
}