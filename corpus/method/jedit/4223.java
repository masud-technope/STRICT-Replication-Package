/**
	 * Creates a variable grid layout manager with the specified mode,
	 * size, horizontal and vertical gap, and zero distance to borders.
	 * The minimum and maximum Component sizes are not taken into account
	 * when distributing free space.
	 *
	 * @param mode The mode in which to operate. Either FIXED_NUM_ROWS or FIXED_NUM_COLUMNS
	 * @param size The amount of rows for mode FIXED_NUM_ROWS or the amount of columns for mode FIXED_NUM_COLUMNS
	 * @param hgap The horizontal space between cells
	 * @param vgap The vertical space between cells
	 * @throws IllegalArgumentException if mode is not either FIXED_NUM_ROWS or FIXED_NUM_COLUMNS or size is&lt;= 0 or hgap or vgap is &lt; 0
	 */
public  VariableGridLayout(int mode, int size, int hgap, int vgap) {
    this(mode, size, hgap, vgap, false, new Insets(0, 0, 0, 0));
}