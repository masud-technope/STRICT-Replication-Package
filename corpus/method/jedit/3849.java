//}}}
//{{{ getWrappedDimension() method
/**
	 * Returns the width or height of wrapped rows or columns.
	 */
int getWrappedDimension(int dimension) {
    return ((ButtonLayout) buttonPanel.getLayout()).getWrappedDimension(buttonPanel, dimension);
}