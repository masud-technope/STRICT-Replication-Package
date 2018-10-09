//}}}
//{{{ defaultTableDimension() method
/**
	 * JTable cell size, based on global defaults.
	 * @since jEdit 5.3.1
	 */
public static Dimension defaultTableCellSize() {
    JLabel label = new JLabel("miniminiminiminiminiminiminiminiminimini");
    UIDefaults defaults = UIManager.getDefaults();
    Object font = defaults.get("Table.font");
    if (font instanceof Font)
        label.setFont((Font) font);
    return label.getPreferredSize();
}