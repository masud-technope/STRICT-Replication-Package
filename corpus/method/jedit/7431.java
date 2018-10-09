//}}}
//{{{ getEditPanes() method
/**
	 * Returns all edit panes.
	 * @return an array of all edit panes in the view
	 * @since jEdit 2.5pre2
	 */
public EditPane[] getEditPanes() {
    if (splitPane == null) {
        EditPane[] ep = { editPane };
        return ep;
    } else {
        List<EditPane> vec = new ArrayList<EditPane>();
        getEditPanes(vec, splitPane);
        EditPane[] ep = new EditPane[vec.size()];
        vec.toArray(ep);
        return ep;
    }
}