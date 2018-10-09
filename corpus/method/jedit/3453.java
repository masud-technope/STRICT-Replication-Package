/**
	  * Calculates the minimum, preferred or maximum size dimensions
	  * for the specified container, given the components it contains.
	  *
	  * @param parent       The container to be laid out
	  * @param layoutSize   if {@code LayoutSize.MINIMUM} compute minimum layout size,
	  *                     if {@code LayoutSize.PREFERRED} compute preferred layout size,
	  *                     if {@code LayoutSize.MAXIMUM} compute maximum layout size,
	  *                     if {@code fillRawSizes} is {@code true}, the layout size is computed
	  *                     without applying gaps between components or between
	  *                     the grid and the borders of the parent container
	  * @param fillRawSizes Whether to fill the resultArrays with the raw
	  *                     row heights and column widths and whether to apply
	  *                     gaps between components or between
	  *                     the grid and the borders of the parent container
	  *                     when computing the layout size
	  * @param gridSize     The amount of rows and columns in the grid
	  * @param gridRows     The grid holding the constraints for the components
	  * @param colspans     In this {@code Set} the constraints which are part
	  *                     of a colspan are stored
	  * @param rowspans     In this {@code Set} the constraints which are part
	  *                     of a rowspan are stored
	  * @param resultArrays If {@code fillRawSizes} is {@code true}, the first six arrays
	  *                     get filled with the raw row heights and column widths.
	  *                     resultArrays[0] = resultMinimumColWidths;
	  *                     resultArrays[1] = resultMinimumRowHeights;
	  *                     resultArrays[2] = resultPreferredColWidths;
	  *                     resultArrays[3] = resultPreferredRowHeights;
	  *                     resultArrays[4] = resultMaximumColWidths;
	  *                     resultArrays[5] = resultMaximumRowHeights;
	  * @return The minimum, preferred or maximum size dimensions for the specified container
	  * @throws IllegalArgumentException If {@code fillRawSizes == true} and {@code resultArrays.length < 6}
	  */
private Dimension getSize(Container parent, LayoutSize layoutSize, boolean fillRawSizes, Dimension gridSize, List<List<ExtendedGridLayoutConstraints>> gridRows, Set<ExtendedGridLayoutConstraints> colspans, Set<ExtendedGridLayoutConstraints> rowspans, int[][] resultArrays) {
    if (fillRawSizes && (resultArrays.length < 6)) {
        throw new IllegalArgumentException("If fillRawSizes is true, resultArrays.length must be >= 6 (" + resultArrays.length + ')');
    }
    int[] minimumColWidths = new int[gridSize.width];
    int[] minimumRowHeights = new int[gridSize.height];
    int[] preferredColWidths = new int[gridSize.width];
    int[] preferredRowHeights = new int[gridSize.height];
    int[] maximumColWidths = new int[gridSize.width];
    int[] maximumRowHeights = new int[gridSize.height];
    Arrays.fill(minimumColWidths, 0);
    Arrays.fill(minimumRowHeights, 0);
    Arrays.fill(preferredColWidths, 0);
    Arrays.fill(preferredRowHeights, 0);
    Arrays.fill(maximumColWidths, 0);
    Arrays.fill(maximumRowHeights, 0);
    // rowspans and colspans into account
    for (int row = 0; row < gridSize.height; row++) {
        List<ExtendedGridLayoutConstraints> gridRow = gridRows.get(row);
        for (int col = 0; col < gridSize.width; col++) {
            ExtendedGridLayoutConstraints cell = gridRow.get(col);
            if ((null != cell) && (null != cell.getComponent())) {
                Component component = cell.getComponent();
                Dimension minimumSize = component.getMinimumSize();
                Dimension preferredSize = component.getPreferredSize();
                Dimension maximumSize = component.getMaximumSize();
                if (!colspans.contains(cell)) {
                    minimumColWidths[col] = Math.max(minimumColWidths[col], minimumSize.width);
                    preferredColWidths[col] = Math.max(preferredColWidths[col], preferredSize.width);
                    maximumColWidths[col] = Math.max(maximumColWidths[col], maximumSize.width);
                }
                if (!rowspans.contains(cell)) {
                    minimumRowHeights[row] = Math.max(minimumRowHeights[row], minimumSize.height);
                    preferredRowHeights[row] = Math.max(preferredRowHeights[row], preferredSize.height);
                    maximumRowHeights[row] = Math.max(maximumRowHeights[row], maximumSize.height);
                }
            }
        }
    }
    // is not true by clipping to the minimumColWidths and maximumColWidths
    for (int col = 0; col < gridSize.width; col++) {
        if (minimumColWidths[col] >= maximumColWidths[col]) {
            maximumColWidths[col] = minimumColWidths[col];
            preferredColWidths[col] = minimumColWidths[col];
        } else if (preferredColWidths[col] < minimumColWidths[col]) {
            preferredColWidths[col] = minimumColWidths[col];
        } else if (preferredColWidths[col] > maximumColWidths[col]) {
            preferredColWidths[col] = maximumColWidths[col];
        }
    }
    // maximum column widths the colspans are part of
    for (ExtendedGridLayoutConstraints cell : colspans) {
        int fromCol = cell.getCol();
        int colspan = cell.getEffectiveColspan();
        int toCol = fromCol + colspan;
        int currentMinimumColWidth = 0;
        int currentPreferredColWidth = 0;
        int currentMaximumColWidth = 0;
        for (int col = fromCol; col < toCol; col++) {
            int minimumColWidth = minimumColWidths[col];
            if ((Integer.MAX_VALUE - minimumColWidth) < currentMinimumColWidth) {
                currentMinimumColWidth = Integer.MAX_VALUE;
            } else {
                currentMinimumColWidth += minimumColWidth;
            }
            int preferredColWidth = preferredColWidths[col];
            if ((Integer.MAX_VALUE - preferredColWidth) < currentPreferredColWidth) {
                currentPreferredColWidth = Integer.MAX_VALUE;
            } else {
                currentPreferredColWidth += preferredColWidth;
            }
            int maximumColWidth = maximumColWidths[col];
            if ((Integer.MAX_VALUE - maximumColWidth) < currentMaximumColWidth) {
                currentMaximumColWidth = Integer.MAX_VALUE;
            } else {
                currentMaximumColWidth += maximumColWidth;
            }
        }
        Component component = cell.getComponent();
        int wantedMaximumColWidth = component.getMaximumSize().width - ((colspan - 1) * hgap);
        if (currentMaximumColWidth < wantedMaximumColWidth) {
            redistributeSpace(currentMaximumColWidth, wantedMaximumColWidth, fromCol, toCol, maximumColWidths, maximumColWidths, maximumColWidths);
        }
        int wantedMinimumColWidth = component.getMinimumSize().width - ((colspan - 1) * hgap);
        if (currentMinimumColWidth < wantedMinimumColWidth) {
            redistributeSpace(currentMinimumColWidth, wantedMinimumColWidth, fromCol, toCol, minimumColWidths, minimumColWidths, maximumColWidths);
        }
        int wantedPreferredColWidth = component.getPreferredSize().width - ((colspan - 1) * hgap);
        if (currentPreferredColWidth < wantedPreferredColWidth) {
            redistributeSpace(currentPreferredColWidth, wantedPreferredColWidth, fromCol, toCol, preferredColWidths, minimumColWidths, maximumColWidths);
        }
    }
    // is not true by clipping to the minimumColWidths and maximumColWidths
    for (int col = 0; col < gridSize.width; col++) {
        if (minimumColWidths[col] >= maximumColWidths[col]) {
            maximumColWidths[col] = minimumColWidths[col];
            preferredColWidths[col] = minimumColWidths[col];
        } else if (preferredColWidths[col] < minimumColWidths[col]) {
            preferredColWidths[col] = minimumColWidths[col];
        } else if (preferredColWidths[col] > maximumColWidths[col]) {
            preferredColWidths[col] = maximumColWidths[col];
        }
    }
    // is not true by clipping to the minimumRowHeights and maximumRowHeights
    for (int row = 0; row < gridSize.height; row++) {
        if (minimumRowHeights[row] >= maximumRowHeights[row]) {
            maximumRowHeights[row] = minimumRowHeights[row];
            preferredRowHeights[row] = minimumRowHeights[row];
        } else if (preferredRowHeights[row] < minimumRowHeights[row]) {
            preferredRowHeights[row] = minimumRowHeights[row];
        } else if (preferredRowHeights[row] > maximumRowHeights[row]) {
            preferredRowHeights[row] = maximumRowHeights[row];
        }
    }
    // maximum row heights the rowspans are part of
    for (ExtendedGridLayoutConstraints cell : rowspans) {
        int fromRow = cell.getRow();
        int rowspan = cell.getEffectiveRowspan();
        int toRow = fromRow + rowspan;
        int currentMinimumRowHeight = 0;
        int currentPreferredRowHeight = 0;
        int currentMaximumRowHeight = 0;
        for (int row = fromRow; row < toRow; row++) {
            int minimumRowHeight = minimumRowHeights[row];
            if ((Integer.MAX_VALUE - minimumRowHeight) < currentMinimumRowHeight) {
                currentMinimumRowHeight = Integer.MAX_VALUE;
            } else {
                currentMinimumRowHeight += minimumRowHeight;
            }
            int preferredRowHeight = preferredRowHeights[row];
            if ((Integer.MAX_VALUE - preferredRowHeight) < currentPreferredRowHeight) {
                currentPreferredRowHeight = Integer.MAX_VALUE;
            } else {
                currentPreferredRowHeight += preferredRowHeight;
            }
            int maximumRowHeight = maximumRowHeights[row];
            if ((Integer.MAX_VALUE - maximumRowHeight) < currentMaximumRowHeight) {
                currentMaximumRowHeight = Integer.MAX_VALUE;
            } else {
                currentMaximumRowHeight += maximumRowHeight;
            }
        }
        Component component = cell.getComponent();
        int wantedMaximumRowHeight = component.getMaximumSize().height - ((rowspan - 1) * vgap);
        if (currentMaximumRowHeight < wantedMaximumRowHeight) {
            redistributeSpace(currentMaximumRowHeight, wantedMaximumRowHeight, fromRow, toRow, maximumRowHeights, maximumRowHeights, maximumRowHeights);
        }
        int wantedMinimumRowHeight = component.getMinimumSize().height - ((rowspan - 1) * vgap);
        if (currentMinimumRowHeight < wantedMinimumRowHeight) {
            redistributeSpace(currentMinimumRowHeight, wantedMinimumRowHeight, fromRow, toRow, minimumRowHeights, minimumRowHeights, maximumRowHeights);
        }
        int wantedPreferredRowHeight = component.getPreferredSize().height - ((rowspan - 1) * vgap);
        if (currentPreferredRowHeight < wantedPreferredRowHeight) {
            redistributeSpace(currentPreferredRowHeight, wantedPreferredRowHeight, fromRow, toRow, preferredRowHeights, minimumRowHeights, maximumRowHeights);
        }
    }
    // is not true by clipping to the minimumRowHeights and maximumRowHeights
    for (int row = 0; row < gridSize.height; row++) {
        if (minimumRowHeights[row] >= maximumRowHeights[row]) {
            maximumRowHeights[row] = minimumRowHeights[row];
            preferredRowHeights[row] = minimumRowHeights[row];
        } else if (preferredRowHeights[row] < minimumRowHeights[row]) {
            preferredRowHeights[row] = minimumRowHeights[row];
        } else if (preferredRowHeights[row] > maximumRowHeights[row]) {
            preferredRowHeights[row] = maximumRowHeights[row];
        }
    }
    // copies the computed sizes to the result arrays
    if (fillRawSizes) {
        resultArrays[0] = minimumColWidths;
        resultArrays[1] = minimumRowHeights;
        resultArrays[2] = preferredColWidths;
        resultArrays[3] = preferredRowHeights;
        resultArrays[4] = maximumColWidths;
        resultArrays[5] = maximumRowHeights;
    }
    // sums up the sizes for return value
    int[] colWidths;
    int[] rowHeights;
    switch(layoutSize) {
        case MINIMUM:
            colWidths = minimumColWidths;
            rowHeights = minimumRowHeights;
            break;
        case PREFERRED:
            colWidths = preferredColWidths;
            rowHeights = preferredRowHeights;
            break;
        case MAXIMUM:
            colWidths = maximumColWidths;
            rowHeights = maximumRowHeights;
            break;
        default:
            throw new InternalError("Missing case branch for LayoutSize: " + layoutSize);
    }
    long totalWidth = 0;
    long totalHeight = 0;
    for (int width : colWidths) {
        totalWidth += width;
    }
    for (int height : rowHeights) {
        totalHeight += height;
    }
    // componetns and the borders of the parent container
    if (!fillRawSizes) {
        Insets insets = parent.getInsets();
        totalWidth += insets.left + insets.right + ((gridSize.width - 1) * hgap) + distanceToBorders.left + distanceToBorders.right;
        totalHeight += insets.top + insets.bottom + ((gridSize.height - 1) * vgap) + distanceToBorders.top + distanceToBorders.bottom;
    }
    // clip the size to Integer.MAX_VALUE if too big
    if (totalWidth > Integer.MAX_VALUE) {
        totalWidth = Integer.MAX_VALUE;
    }
    if (totalHeight > Integer.MAX_VALUE) {
        totalHeight = Integer.MAX_VALUE;
    }
    return new Dimension((int) totalWidth, (int) totalHeight);
}