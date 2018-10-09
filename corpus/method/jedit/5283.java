//}}}
//{{{ edit() method
private void edit() {
    AbbrevsModel abbrevsModel = (AbbrevsModel) abbrevsTable.getModel();
    int row = abbrevsTable.getSelectedRow();
    String abbrev = (String) abbrevsModel.getValueAt(row, 0);
    String expansion = (String) abbrevsModel.getValueAt(row, 1);
    String oldAbbrev = abbrev;
    EditAbbrevDialog dialog = new EditAbbrevDialog(GenericGUIUtilities.getParentDialog(AbbrevsOptionPane.this), abbrev, expansion, abbrevsModel.toHashtable());
    abbrev = dialog.getAbbrev();
    expansion = dialog.getExpansion();
    if (abbrev != null && expansion != null) {
        for (int i = 0; i < abbrevsModel.getRowCount(); i++) {
            if (abbrevsModel.getValueAt(i, 0).equals(oldAbbrev)) {
                abbrevsModel.remove(i);
                break;
            }
        }
        add(abbrevsModel, abbrev, expansion);
    }
}