public void actionPerformed(ActionEvent evt) {
    AbbrevsModel abbrevsModel = (AbbrevsModel) abbrevsTable.getModel();
    Object source = evt.getSource();
    if (source == setsComboBox) {
        jEdit.setIntegerProperty("options.abbrevs.combobox.index", setsComboBox.getSelectedIndex());
        String selected = (String) setsComboBox.getSelectedItem();
        if (selected.equals("global")) {
            abbrevsTable.setModel(globalAbbrevs);
        } else {
            abbrevsTable.setModel(modeAbbrevs.get(selected));
        }
        updateEnabled();
    } else if (source == add) {
        EditAbbrevDialog dialog = new EditAbbrevDialog(GenericGUIUtilities.getParentDialog(AbbrevsOptionPane.this), null, null, abbrevsModel.toHashtable());
        String abbrev = dialog.getAbbrev();
        String expansion = dialog.getExpansion();
        if (abbrev != null && abbrev.length() != 0 && expansion != null && expansion.length() != 0) {
            add(abbrevsModel, abbrev, expansion);
        }
    } else if (source == edit) {
        edit();
    } else if (source == remove) {
        int selectedRow = abbrevsTable.getSelectedRow();
        abbrevsModel.remove(selectedRow);
        updateEnabled();
    }
}