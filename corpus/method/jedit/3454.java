/**
	  * Builds up the grid for the specified container,
	  * given the components it contains.
	  *
	  * @param parent   The container to be laid out
	  * @param gridRows In this {@code List<List>} the grid gets stored
	  * @param colspans In this {@code Set} the constraints which are part
	  *                 of a colspan get stored
	  * @param rowspans In this {@code Set} the constraints which are part
	  *                 of a rowspan get stored
	  * @return The amount of rows and columns in the grid
	  */
private Dimension buildGrid(Container parent, List<List<ExtendedGridLayoutConstraints>> gridRows, Set<ExtendedGridLayoutConstraints> colspans, Set<ExtendedGridLayoutConstraints> rowspans) {
    // put the parent's components in source rows
    List<List<ExtendedGridLayoutConstraints>> rows = new ArrayList<List<ExtendedGridLayoutConstraints>>();
    Component[] components = parent.getComponents();
    for (Component component : components) {
        if (component.isVisible()) {
            ExtendedGridLayoutConstraints constraints = lookupConstraints(component).getWorkCopy();
            int rowNumber = constraints.getRow();
            for (int i = rowNumber, c = rows.size(); i >= c; i--) {
                rows.add(new ArrayList<ExtendedGridLayoutConstraints>());
            }
            List<ExtendedGridLayoutConstraints> row = rows.get(rowNumber);
            row.add(constraints);
        }
    }
    // initialize the rowIterators, gridRowIterators and gridRows
    List<Iterator<ExtendedGridLayoutConstraints>> rowIterators = new ArrayList<Iterator<ExtendedGridLayoutConstraints>>();
    List<ListIterator<ExtendedGridLayoutConstraints>> gridRowIterators = new ArrayList<ListIterator<ExtendedGridLayoutConstraints>>();
    boolean haveNext = false;
    for (List<ExtendedGridLayoutConstraints> row : rows) {
        Iterator<ExtendedGridLayoutConstraints> rowIterator = row.iterator();
        rowIterators.add(rowIterator);
        if (rowIterator.hasNext()) {
            haveNext = true;
        }
        List<ExtendedGridLayoutConstraints> gridRow = new ArrayList<ExtendedGridLayoutConstraints>();
        gridRows.add(gridRow);
        gridRowIterators.add(gridRow.listIterator());
    }
    // build the grid
    int col = -1;
    while (haveNext) {
        col++;
        haveNext = false;
        for (int row = 0, c = gridRows.size(); row < c; row++) {
            Iterator<ExtendedGridLayoutConstraints> rowIterator = rowIterators.get(row);
            ListIterator<ExtendedGridLayoutConstraints> gridRowIterator = gridRowIterators.get(row);
            // look for a rowspan in the previous row
            if (row > 0) {
                ExtendedGridLayoutConstraints rowspanSource = gridRows.get(row - 1).get(col);
                if (null != rowspanSource) {
                    ExtendedGridLayoutConstraints rowspanPlaceholder = rowspanSource.getRowspanPlaceholder(true);
                    if (null != rowspanPlaceholder) {
                        rowspans.add(rowspanSource);
                        gridRowIterator.add(rowspanPlaceholder);
                        if (null != rowspanPlaceholder.getColspanPlaceholder(false)) {
                            switch(rowspanPlaceholder.getColspan()) {
                                case REMAINDER:
                                    break;
                                default:
                                    haveNext = true;
                            }
                        } else if (rowIterator.hasNext()) {
                            haveNext = true;
                        }
                        continue;
                    }
                }
            }
            // look for a colspan in the previous column
            if (gridRowIterator.hasPrevious()) {
                ExtendedGridLayoutConstraints colspanSource = gridRowIterator.previous();
                gridRowIterator.next();
                if (null != colspanSource) {
                    ExtendedGridLayoutConstraints colspanPlaceholder = colspanSource.getColspanPlaceholder(true);
                    if (null != colspanPlaceholder) {
                        colspans.add(colspanSource);
                        gridRowIterator.add(colspanPlaceholder);
                        if (null != colspanPlaceholder.getColspanPlaceholder(false)) {
                            switch(colspanPlaceholder.getColspan()) {
                                case REMAINDER:
                                    break;
                                default:
                                    haveNext = true;
                            }
                        } else if (rowIterator.hasNext()) {
                            haveNext = true;
                        }
                        continue;
                    }
                }
            }
            // add a new element or null
            if (rowIterator.hasNext()) {
                ExtendedGridLayoutConstraints newConstraints = rowIterator.next();
                newConstraints.setCol(col);
                gridRowIterator.add(newConstraints);
                if (null != newConstraints.getColspanPlaceholder(false)) {
                    switch(newConstraints.getColspan()) {
                        case REMAINDER:
                            break;
                        default:
                            haveNext = true;
                    }
                } else if (rowIterator.hasNext()) {
                    haveNext = true;
                }
            } else {
                gridRowIterator.add(null);
            }
        }
    }
    // check the last gridRow for rowspans and probably add rows for these
    haveNext = false;
    int gridRowsSize = gridRows.size();
    if (gridRowsSize > 0) {
        for (ExtendedGridLayoutConstraints cell : gridRows.get(gridRows.size() - 1)) {
            if ((null != cell) && ((REMAINDER != cell.getRowspan()) && (null != cell.getRowspanPlaceholder(false)))) {
                haveNext = true;
                break;
            }
        }
        while (haveNext) {
            haveNext = false;
            ListIterator<ExtendedGridLayoutConstraints> gridRowIterator = gridRows.get(gridRows.size() - 1).listIterator();
            List<ExtendedGridLayoutConstraints> gridRow = new ArrayList<ExtendedGridLayoutConstraints>();
            gridRows.add(gridRow);
            ListIterator<ExtendedGridLayoutConstraints> newGridRowIterator = gridRow.listIterator();
            while (gridRowIterator.hasNext()) {
                ExtendedGridLayoutConstraints cell = gridRowIterator.next();
                if ((null != cell) && (null != cell.getRowspanPlaceholder(false))) {
                    rowspans.add(cell);
                    ExtendedGridLayoutConstraints rowspanPlaceholder = cell.getRowspanPlaceholder(true);
                    newGridRowIterator.add(rowspanPlaceholder);
                } else {
                    newGridRowIterator.add(null);
                }
            }
            gridRowIterator = gridRow.listIterator();
            while (gridRowIterator.hasNext()) {
                ExtendedGridLayoutConstraints cell = gridRowIterator.next();
                if ((null != cell) && ((REMAINDER != cell.getRowspan()) && (null != cell.getRowspanPlaceholder(false)))) {
                    haveNext = true;
                    break;
                }
            }
        }
    }
    return new Dimension(col + 1, gridRows.size());
}