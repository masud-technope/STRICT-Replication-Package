//}}}
//{{{ configureTreeCellRendererComponent() method
/**
	 * Configures this instance of the renderer component based on the passed in
	 * components. The value is set from messaging the tree with convertValueToText,
	 * which ultimately invokes toString on value. The foreground color is set
	 * based on the selection and the icon is set based on the leaf and expanded
	 * parameters. The parameters of this method are the same as the ones of
	 * {@link #getTreeCellRendererComponent(JTree, Object, boolean, boolean, boolean, int, boolean)}.
	 *
	 * @param tree     The tree in which this renderer component is used currently
	 * @param value    The value to be displayed for the tree cell to be rendered
	 * @param selected Whether the tree cell to be rendered is selected
	 * @param expanded Whether the tree cell to be rendered is expanded
	 * @param leaf     Whether the tree cell to be rendered is a leaf
	 * @param row      The row index of the tree cell to be rendered
	 * @param hasFocus Whether the tree cell to be rendered has the focus
	 */
protected abstract void configureTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus);