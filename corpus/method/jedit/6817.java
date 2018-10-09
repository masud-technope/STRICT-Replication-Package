//}}}
//{{{ setExpanded() method
/**
	 * Sets whether the gutter is collapsed or expanded and force the text
	 * area to update its layout if there is a change.
	 * @param expanded true if the gutter is expanded,
	 *                   false if it is collapsed
	 */
public void setExpanded(boolean expanded) {
    if (this.expanded == expanded)
        return;
    this.expanded = expanded;
    textArea.revalidate();
}