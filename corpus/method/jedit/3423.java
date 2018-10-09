//{{{ EditAbbrevDialog constructor
public  EditAbbrevDialog(Dialog dialog, String abbrev, String expansion, Map abbrevs) {
    super(dialog, jEdit.getProperty("edit-abbrev.title"), true);
    init(abbrev, expansion, abbrevs);
}