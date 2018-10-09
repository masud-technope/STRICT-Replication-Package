//}}}
//{{{ getDockable method
/**
	 * @since jEdit 4.3pre2
	 */
public JComponent getDockable(String name) {
    return windows.get(name);
}