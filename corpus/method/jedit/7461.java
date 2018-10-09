//}}}
//{{{ appendToSplitConfig() method
/**
	 * Append the Component to the split config.
	 * The component must be a JSplitPane or an EditPane
	 *
	 * @param splitConfig the split config
	 * @param component the component
	 */
private static void appendToSplitConfig(StringBuilder splitConfig, Component component) {
    if (component instanceof JSplitPane) {
        // the component is a JSplitPane
        getSplitConfig((JSplitPane) component, splitConfig);
    } else {
        boolean autosaveUntitled = jEdit.getBooleanProperty("autosaveUntitled");
        // the component is an editPane
        EditPane editPane = (EditPane) component;
        splitConfig.append('"');
        Buffer editPaneBuffer = editPane.getBuffer();
        splitConfig.append(StandardUtilities.charsToEscapes(editPaneBuffer.getPath()));
        splitConfig.append("\" buffer");
        BufferSet bufferSet = editPane.getBufferSet();
        Buffer[] buffers = bufferSet.getAllBuffers();
        for (Buffer buffer : buffers) {
            if (!buffer.isNewFile() || (buffer.isUntitled() && autosaveUntitled)) {
                splitConfig.append(" \"");
                splitConfig.append(StandardUtilities.charsToEscapes(buffer.getPath()));
                splitConfig.append("\" buff");
            }
        }
        splitConfig.append(" \"");
        splitConfig.append(jEdit.getBufferSetManager().getScope());
        splitConfig.append("\" bufferset");
    }
}