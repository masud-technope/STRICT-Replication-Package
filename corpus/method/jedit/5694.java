//{{{ saveSelection() method
/**
		 * Save the selection in the given list.
		 * The list will be filled with the jar names of the selected entries
		 *
		 * @param savedSelection the list where to save the selection
		 */
public void saveSelection(List<String> savedSelection) {
    if (table != null) {
        int[] rows = table.getSelectedRows();
        for (int row : rows) savedSelection.add(entries.get(row).jar);
    }
//}}}
}