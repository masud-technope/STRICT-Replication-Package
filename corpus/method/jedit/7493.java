//}}}
//{{{ setSplitConfig() method
/**
	 * sets the split configuration as per the splitConfig.
	 *
	 * @param buffer if null, checks all buffers to restore View's split config.
	 * @param splitConfig the split config, as returned by getSplitConfig()
	 */
public void setSplitConfig(Buffer buffer, String splitConfig) {
    try {
        Component comp = restoreSplitConfig(buffer, splitConfig);
        setMainContent(comp);
        updateTitle();
    } catch (IOException e) {
        throw new InternalError();
    }
}