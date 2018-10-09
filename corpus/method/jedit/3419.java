//}}}
//{{{ checkForExistingAbbrev() method
private boolean checkForExistingAbbrev() {
    String abbrev = editor.getAbbrev();
    if (abbrevs.get(abbrev) != null) {
        if (abbrev.equals(originalAbbrev))
            return true;
        int result = GUIUtilities.confirm(this, "edit-abbrev.duplicate", null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        return (result == JOptionPane.YES_OPTION);
    }
    return true;
}