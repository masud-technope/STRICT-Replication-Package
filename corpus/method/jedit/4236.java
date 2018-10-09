/**
	 * Returns the string representation of this variable grid layout's values.
	 * @return  a string representation of this variable grid layout.
	 */
public String toString() {
    return getClass().getName() + "[mode=" + ((FIXED_NUM_ROWS == mode) ? "FIXED_NUM_ROWS" : ((FIXED_NUM_COLUMNS == mode) ? "FIXED_NUM_COLUMNS" : "UNKNOWN(" + mode + ")")) + ",size=" + size + ",hgap=" + hgap + ",vgap=" + vgap + ",takeSizesIntoAccount=" + takeSizesIntoAccount + ",distanceToBorders=" + distanceToBorders + "]";
}