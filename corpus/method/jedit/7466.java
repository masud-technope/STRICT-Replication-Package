//}}}
//{{{ getSplitConfig() method
/*
	 * The split config is recorded in a simple RPN "language".
	 */
private static void getSplitConfig(JSplitPane splitPane, StringBuilder splitConfig) {
    Component right = splitPane.getRightComponent();
    appendToSplitConfig(splitConfig, right);
    splitConfig.append(' ');
    Component left = splitPane.getLeftComponent();
    appendToSplitConfig(splitConfig, left);
    splitConfig.append(' ');
    splitConfig.append(splitPane.getDividerLocation());
    splitConfig.append(' ');
    splitConfig.append(splitPane.getOrientation() == JSplitPane.VERTICAL_SPLIT ? "vertical" : "horizontal");
}