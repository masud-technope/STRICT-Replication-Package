/**
	 * Creates a variable grid layout manager with the specified mode,
	 * size, horizontal and vertical gap, eventually taking minimum and maximum
	 * sizes into account when distributing free space, depending on takeSizesIntoAccount
	 * and the specified distance to the borders.
	 *
	 * @param mode The mode in which to operate. Either FIXED_NUM_ROWS or FIXED_NUM_COLUMNS
	 * @param size The amount of rows for mode FIXED_NUM_ROWS or the amount of columns for mode FIXED_NUM_COLUMNS (&gt;0)
	 * @param hgap The horizontal space between cells (&gt;=0)
	 * @param vgap The vertical space between cells (&gt;=0)
	 * @param takeSizesIntoAccount Whether to take minimum and maximum sizes into account when distributing free space
	 *        Javier Diaz Soto (jbds) warns in #2997417 that this may cause gui freeze and provides a patch
	 * @param distanceToBorders The distances to the borders
	 * @throws IllegalArgumentException if mode is not either FIXED_NUM_ROWS or FIXED_NUM_COLUMNS or size is &lt;= 0 or hgap or vgap is &lt; 0
	 */
public  VariableGridLayout(int mode, int size, int hgap, int vgap, boolean takeSizesIntoAccount, Insets distanceToBorders) {
    if (mode != FIXED_NUM_ROWS && mode != FIXED_NUM_COLUMNS) {
        throw new IllegalArgumentException("illegal mode; value is " + mode);
    }
    if (size <= 0) {
        throw new IllegalArgumentException("size cannot be zero or less; value is " + size);
    }
    if (hgap < 0) {
        throw new IllegalArgumentException("hgap cannot be negative; value is " + hgap);
    }
    if (vgap < 0) {
        throw new IllegalArgumentException("vgap cannot be negative; value is " + vgap);
    }
    this.mode = mode;
    this.size = size;
    this.hgap = hgap;
    this.vgap = vgap;
    this.takeSizesIntoAccount = takeSizesIntoAccount;
    this.distanceToBorders = (Insets) distanceToBorders.clone();
}