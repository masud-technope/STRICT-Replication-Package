//}}}
//{{{ getTextArea() method
/**
	 * Returns the current edit pane's text area.
	 * @return the current edit pane's text area, or <b>null</b> if there is no edit pane yet
	 */
public JEditTextArea getTextArea() {
    if (editPane == null)
        return null;
    else
        return editPane.getTextArea();
}