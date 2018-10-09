//}}}
//{{{ createMultilineLabel() method
/**
	 * Creates a component that displays a multiple line message. This
	 * is implemented by assembling a number of <code>JLabels</code> in
	 * a <code>JPanel</code>.
	 * @param str The string, with lines delimited by newline
	 * (<code>\n</code>) characters.
	 * @since jEdit 4.1pre3
	 */
public static JComponent createMultilineLabel(String str) {
    JPanel panel = new JPanel(new VariableGridLayout(VariableGridLayout.FIXED_NUM_COLUMNS, 1, 1, 1));
    int lastOffset = 0;
    while (true) {
        int index = str.indexOf('\n', lastOffset);
        if (index == -1)
            break;
        else {
            panel.add(new JLabel(str.substring(lastOffset, index)));
            lastOffset = index + 1;
        }
    }
    if (lastOffset != str.length())
        panel.add(new JLabel(str.substring(lastOffset)));
    return panel;
}