/**
	  * @param col The column in which the component starts its display area.
	  */
void setCol(int col) {
    if (col < 0) {
        throw new IllegalArgumentException("col must be non-negative (" + col + ')');
    }
    this.col = col;
}