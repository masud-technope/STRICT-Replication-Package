/**
	 * @since jEdit 4.2pre3
	 */
public  EditAbbrevDialog(Frame frame, String abbrev, String expansion, Map abbrevs) {
    super(frame, jEdit.getProperty("edit-abbrev.title"), true);
    init(abbrev, expansion, abbrevs);
}