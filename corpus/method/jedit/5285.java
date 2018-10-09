//}}}
//{{{ _save() method
@Override
protected void _save() {
    if (abbrevsTable.getCellEditor() != null)
        abbrevsTable.getCellEditor().stopCellEditing();
    Abbrevs.setExpandOnInput(expandOnInput.isSelected());
    Abbrevs.setGlobalAbbrevs(globalAbbrevs.toHashtable());
    Hashtable<String, Hashtable<String, String>> modeHash = new Hashtable<String, Hashtable<String, String>>();
    Set<Map.Entry<String, AbbrevsModel>> entrySet = modeAbbrevs.entrySet();
    for (Map.Entry<String, AbbrevsModel> entry : entrySet) {
        modeHash.put(entry.getKey(), entry.getValue().toHashtable());
    }
    Abbrevs.setModeAbbrevs(modeHash);
}