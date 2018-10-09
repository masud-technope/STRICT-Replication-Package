//}}}
//{{{ newLabel()
/**
	 * @param label The label to associate with comp
	 * @param comp The component to associate the label
	 * @return a label which has the same tooltiptext as the Component
	 *    that it is a label for. This is used to create labels from inside
	 *    AbstractOptionPane.
	 * @since jEdit 4.3pre4
	 */
public JLabel newLabel(String label, Component comp) {
    JLabel retval = new JLabel(label);
    /* to get the tooltip of the component */
    try {
        JComponent jc = (JComponent) comp;
        String tttext = jc.getToolTipText();
        retval.setToolTipText(tttext);
    } catch (Exception e) {
    }
    return retval;
}