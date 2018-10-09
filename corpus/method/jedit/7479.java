//}}}
//}}}
//{{{ Buffers, edit panes, split panes
//{{{ splitHorizontally() method
/**
	 * Splits the view horizontally.
	 * @return the new editPane
	 * @since jEdit 4.1pre2
	 */
public EditPane splitHorizontally() {
    return split(JSplitPane.VERTICAL_SPLIT);
}