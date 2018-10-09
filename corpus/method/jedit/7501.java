//}}}
//{{{ resplit() method
/**
	 * Restore the split configuration as it was before unsplitting.
	 *
	 * @since jEdit 4.3pre1
	 */
public void resplit() {
    if (lastSplitConfig == null)
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    else
        setSplitConfig(null, lastSplitConfig);
}