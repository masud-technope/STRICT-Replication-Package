/**
	  * Lays out the specified container.
	  *
	  * @param parent The container to be laid out
	  */
public void layoutContainer(Container parent) {
    synchronized (parent.getTreeLock()) {
        // Pass 1: build the grid
        List<List<ExtendedGridLayoutConstraints>> gridRows = new ArrayList<List<ExtendedGridLayoutConstraints>>();
        Set<ExtendedGridLayoutConstraints> colspans = new HashSet<ExtendedGridLayoutConstraints>();
        Set<ExtendedGridLayoutConstraints> rowspans = new HashSet<ExtendedGridLayoutConstraints>();
        Dimension gridSize = buildGrid(parent, gridRows, colspans, rowspans);
        // Pass 2: compute minimum, preferred and maximum column widths / row heights
        int[][] layoutSizes = new int[6][];
        Dimension preferredSize = getSize(parent, LayoutSize.PREFERRED, true, gridSize, gridRows, colspans, rowspans, layoutSizes);
        int[] minimumColWidths = layoutSizes[0];
        int[] minimumRowHeights = layoutSizes[1];
        int[] preferredColWidths = layoutSizes[2];
        int[] preferredRowHeights = layoutSizes[3];
        int[] maximumColWidths = layoutSizes[4];
        int[] maximumRowHeights = layoutSizes[5];
        // Pass 3: redistribute free space
        Dimension parentSize = parent.getSize();
        Insets insets = parent.getInsets();
        int freeWidth = parentSize.width - insets.left - insets.right - (gridSize.width - 1) * hgap - distanceToBorders.left - distanceToBorders.right;
        int freeHeight = parentSize.height - insets.top - insets.bottom - (gridSize.height - 1) * vgap - distanceToBorders.top - distanceToBorders.bottom;
        redistributeSpace(preferredSize.width, freeWidth, 0, gridSize.width, preferredColWidths, minimumColWidths, maximumColWidths);
        redistributeSpace(preferredSize.height, freeHeight, 0, gridSize.height, preferredRowHeights, minimumRowHeights, maximumRowHeights);
        // Pass 4: layout components
        for (int row = 0, y = insets.top + distanceToBorders.top; row < gridSize.height; y += preferredRowHeights[row] + vgap, row++) {
            List<ExtendedGridLayoutConstraints> gridRow = gridRows.get(row);
            for (int col = 0, x = insets.left + distanceToBorders.left; col < gridSize.width; x += preferredColWidths[col] + hgap, col++) {
                ExtendedGridLayoutConstraints cell = gridRow.get(col);
                if ((null != cell) && (null != cell.getComponent()) && !cell.isPlaceholder()) {
                    Component component = cell.getComponent();
                    Dimension maxSize = component.getMaximumSize();
                    int fromCol = cell.getCol();
                    int colspan = cell.getEffectiveColspan();
                    int toCol = fromCol + colspan;
                    int width = 0;
                    for (int col2 = fromCol; col2 < toCol; col2++) {
                        width += preferredColWidths[col2];
                    }
                    width += (colspan - 1) * hgap;
                    int fromRow = cell.getRow();
                    int rowspan = cell.getEffectiveRowspan();
                    int toRow = fromRow + rowspan;
                    int height = 0;
                    for (int row2 = fromRow; row2 < toRow; row2++) {
                        height += preferredRowHeights[row2];
                    }
                    height += (rowspan - 1) * vgap;
                    int xCorrection = 0;
                    int yCorrection = 0;
                    if (width > maxSize.width) {
                        xCorrection = (int) ((width - maxSize.width) * component.getAlignmentX());
                        width = maxSize.width;
                    }
                    if (height > maxSize.height) {
                        yCorrection = (int) ((height - maxSize.height) * component.getAlignmentY());
                        height = maxSize.height;
                    }
                    component.setBounds(x + xCorrection, y + yCorrection, width, height);
                }
            }
        }
    }
}