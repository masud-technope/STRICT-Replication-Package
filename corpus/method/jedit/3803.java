//}}}
//{{{ Protected members
// {{{ createOptionTreeModel
/**
	 * Creates the tree model that goes on the left of the option pane,
	 * loading all the items that are needed.
	 * @return OptionTreeModel for binary compatibility of plugins (e.g. SideKick)
	 */
protected abstract OptionTreeModel createOptionTreeModel();