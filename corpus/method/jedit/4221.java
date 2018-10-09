/**
	 * Creates a variable grid layout manager with mode FIXED_NUM_ROWS,
	 * number of rows == 1, zero horizontal and vertical gap, and zero distance to borders.
	 * Does not take minimum and maximum Component sizes into account when
	 * distributing free space.
	 */
public  VariableGridLayout() {
    this(FIXED_NUM_ROWS, 1, 0, 0, false, new Insets(0, 0, 0, 0));
}