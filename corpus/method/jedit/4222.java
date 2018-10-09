/**
	 * Creates a variable grid layout manager with the specified mode
	 * and size, zero horizontal and vertical gap, and zero distance to borders.
	 * Does not take minimum and maximum Component sizes into account when distributing
	 * free space.
	 *
	 * @param mode The mode in which to operate. Either FIXED_NUM_ROWS or FIXED_NUM_COLUMNS
	 * @param size The amount of rows for mode FIXED_NUM_ROWS or the amount of columns for mode FIXED_NUM_COLUMNS
	 * @throws IllegalArgumentException if mode is not either FIXED_NUM_ROWS or FIXED_NUM_COLUMNS or size is &lt;= 0
	 */
public  VariableGridLayout(int mode, int size) {
    this(mode, size, 0, 0, false, new Insets(0, 0, 0, 0));
}