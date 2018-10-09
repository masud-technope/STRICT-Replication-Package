//}}}
//{{{ recentBuffer() method
/**
	 * Selects the most recently edited buffer.
	 * @since jEdit 2.7pre2
	 */
public void recentBuffer() {
    if (recentBuffer != null)
        setBuffer(recentBuffer);
    else
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
}