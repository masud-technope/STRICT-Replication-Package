//}}}
//{{{ evalSelection() method
/**
	 * Evaluates the text selected in the specified text area.
	 * @param param some sort of parameter
	 * @param textArea the textArea
	 */
public void evalSelection(T param, TextArea textArea) {
    String command = textArea.getSelectedText();
    if (command == null) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    Object returnValue = eval(param, global, command);
    if (returnValue != null)
        textArea.setSelectedText(returnValue.toString());
}