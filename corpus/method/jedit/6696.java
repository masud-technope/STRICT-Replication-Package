//}}}
//{{{ expandFolds() method
/**
	 * This method should only be called from <code>actions.xml</code>.
	 * @since jEdit 4.2pre1
	 */
public void expandFolds(char digit) {
    if (digit < '1' || digit > '9') {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    } else
        expandFolds((digit - '1') + 1);
}