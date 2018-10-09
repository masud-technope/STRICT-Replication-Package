/**
		 * Invoked when an action occurs.
		 */
@Override
public void actionPerformed(ActionEvent e) {
    SearchAndReplace.setSearchString(hyperSearchOperationNode.getSearchString());
    SearchAndReplace.setSearchMatcher(hyperSearchOperationNode.getSearchMatcher());
    removeSelectedNode();
    SearchAndReplace.hyperSearch(view, false);
}