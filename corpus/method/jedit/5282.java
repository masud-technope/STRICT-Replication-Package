//}}}
//{{{ add() method
private void add(AbbrevsModel abbrevsModel, String abbrev, String expansion) {
    for (int i = 0; i < abbrevsModel.getRowCount(); i++) {
        if (abbrevsModel.getValueAt(i, 0).equals(abbrev)) {
            abbrevsModel.remove(i);
            break;
        }
    }
    abbrevsModel.add(abbrev, expansion);
    updateEnabled();
}