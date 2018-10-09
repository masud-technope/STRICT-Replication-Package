//}}}
//{{{ getSplitConfig() method
/**
	*   Split configurations are recorded in a simple RPN "language".
	*   @return The split configuration, describing where splitpanes
	*           are, which buffers are open in each EditPane, etc.
	*
	*/
public String getSplitConfig() {
    StringBuilder splitConfig = new StringBuilder();
    if (splitPane != null)
        getSplitConfig(splitPane, splitConfig);
    else {
        appendToSplitConfig(splitConfig, editPane);
    }
    return splitConfig.toString();
}