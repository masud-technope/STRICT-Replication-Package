//}}}
//{{{ setSelectedIndex() method
/**
	 * Set selection.
	 */
public void setSelectedIndex(int index) {
    if (candidates != null && 0 <= index && index < candidates.getSize()) {
        list.setSelectedIndex(index);
        list.ensureIndexIsVisible(index);
        String description = candidates.getDescription(index);
        if (description != null) {
            view.getStatus().setMessageAndClear(description);
        }
    }
}