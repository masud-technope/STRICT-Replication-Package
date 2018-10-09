/**
	 * Creates a variable grid layout manager with the specified mode,
	 * size, horizontal and vertical gap, eventually taking minimum and maximum
	 * sizes into account when distributing free space, depending on takeSizesIntoAccount
	 * and zero distance to borders.
	 *
	 * @param mode The mode in which to operate. Either FIXED_NUM_ROWS or FIXED_NUM_COLUMNS
	 * @param size The amount of rows for mode FIXED_NUM_ROWS or the amount of columns for mode FIXED_NUM_COLUMNS (&gt;0)
	 * @param hgap The horizontal space between cells (&gt;=0)
	 * @param vgap The vertical space between cells (&gt;=0)
	 * @param takeSizesIntoAccount Whether to take minimum and maximum sizes into account when distributing free space
	 *        Javier Diaz Soto (jbds) warns in #2997417 that this may cause gui freeze and provides a patch
	 * @throws IllegalArgumentException if mode is not either FIXED_NUM_ROWS or FIXED_NUM_COLUMNS or size is &lt;= 0 or hgap or vgap is &lt; 0
	 */
public  VariableGridLayout(int mode, int size, int hgap, int vgap, boolean takeSizesIntoAccount) {
    this(mode, size, hgap, vgap, takeSizesIntoAccount, new Insets(0, 0, 0, 0));
}