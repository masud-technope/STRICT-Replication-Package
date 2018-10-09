/**
	  * Calculates the preferred size dimensions for the specified
	  * container, given the components it contains.
	  *
	  * @param parent The container to be laid out
	  * @return The preferred size for the container
	  * @see #maximumLayoutSize
	  * @see #minimumLayoutSize
	  */
public Dimension preferredLayoutSize(Container parent) {
    synchronized (parent.getTreeLock()) {
        List<List<ExtendedGridLayoutConstraints>> gridRows = new ArrayList<List<ExtendedGridLayoutConstraints>>();
        Set<ExtendedGridLayoutConstraints> colspans = new HashSet<ExtendedGridLayoutConstraints>();
        Set<ExtendedGridLayoutConstraints> rowspans = new HashSet<ExtendedGridLayoutConstraints>();
        Dimension gridSize = buildGrid(parent, gridRows, colspans, rowspans);
        return getSize(parent, LayoutSize.PREFERRED, false, gridSize, gridRows, colspans, rowspans, new int[0][0]);
    }
}