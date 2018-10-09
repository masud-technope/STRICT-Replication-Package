//}}}
//{{{ setLabel() method
/**
	 * Sets the action source label.
	 * @param label The label
	 * @since jEdit 4.0pre1
	 */
public void setLabel(String label) {
    if (label == null)
        throw new NullPointerException();
    this.label = label;
}