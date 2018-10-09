//}}}
//{{{ getToolTipText() method
/**
	 * Returns the tool tip to display at the specified location.
	 * @param evt The mouse event
	 */
@Override
public String getToolTipText(MouseEvent evt) {
    if (textArea.getBuffer().isLoading())
        return null;
    return extensionMgr.getToolTipText(evt.getX(), evt.getY());
}