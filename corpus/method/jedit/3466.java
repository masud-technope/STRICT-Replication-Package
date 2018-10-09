/**
	  * Calculates the minimum size dimensions for the specified
	  * container, given the components it contains.
	  *
	  * @param parent The component to be laid out
	  * @return The minimum size for the container
	  * @see #maximumLayoutSize
	  * @see #preferredLayoutSize
	  */
public Dimension minimumLayoutSize(Container parent) {
    synchronized (parent.getTreeLock()) {
        List<List<ExtendedGridLayoutConstraints>> gridRows = new ArrayList<List<ExtendedGridLayoutConstraints>>();
        Set<ExtendedGridLayoutConstraints> colspans = new HashSet<ExtendedGridLayoutConstraints>();
        Set<ExtendedGridLayoutConstraints> rowspans = new HashSet<ExtendedGridLayoutConstraints>();
        Dimension gridSize = buildGrid(parent, gridRows, colspans, rowspans);
        return getSize(parent, LayoutSize.MINIMUM, false, gridSize, gridRows, colspans, rowspans, new int[0][0]);
    }
}