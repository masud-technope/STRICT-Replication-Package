//}}}
// {{{ get(TextArea) method
/**
	 * Returns the EditPane of a TextArea.
	 *
	 * @param ta the textArea
	 * @return the EditPane containing the TextArea.
	 */
public static EditPane get(TextArea ta) {
    if (ta == null)
        return null;
    return (EditPane) SwingUtilities.getAncestorOfClass(EditPane.class, ta);
}