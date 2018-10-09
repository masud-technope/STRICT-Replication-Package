public void layoutContainer(Container parent) {
    synchronized (parent.getTreeLock()) {
        update(parent);
        int ncomponents = parent.getComponentCount();
        if (ncomponents == 0) {
            return;
        }
        // Pass 1: compute minimum, preferred and maximum row heights / column widths
        int total_height = 0;
        Arrays.fill(row_heights, 0);
        Arrays.fill(col_widths, 0);
        if (takeSizesIntoAccount) {
            Arrays.fill(minimum_row_heights, 0);
            Arrays.fill(minimum_col_widths, 0);
            Arrays.fill(maximum_row_heights, Integer.MAX_VALUE);
            Arrays.fill(maximum_col_widths, Integer.MAX_VALUE);
        }
        for (int r = 0, i = 0; r < nrows; r++) {
            for (int c = 0; c < ncols; c++, i++) {
                if (i < ncomponents) {
                    Component comp = parent.getComponent(i);
                    Dimension d = comp.getPreferredSize();
                    row_heights[r] = Math.max(row_heights[r], d.height);
                    col_widths[c] = Math.max(col_widths[c], d.width);
                    if (takeSizesIntoAccount) {
                        d = comp.getMinimumSize();
                        minimum_row_heights[r] = Math.max(minimum_row_heights[r], d.height);
                        minimum_col_widths[c] = Math.max(minimum_col_widths[c], d.width);
                        d = comp.getMaximumSize();
                        maximum_row_heights[r] = Math.min(maximum_row_heights[r], d.height);
                        maximum_col_widths[c] = Math.min(maximum_col_widths[c], d.width);
                    }
                } else {
                    break;
                }
            }
            if (takeSizesIntoAccount) {
                // is not true by clipping to the minimum_row_heights and maximum_row_heights
                if (minimum_row_heights[r] >= maximum_row_heights[r]) {
                    maximum_row_heights[r] = minimum_row_heights[r];
                    row_heights[r] = minimum_row_heights[r];
                } else if (row_heights[r] < minimum_row_heights[r]) {
                    row_heights[r] = minimum_row_heights[r];
                } else if (row_heights[r] > maximum_row_heights[r]) {
                    row_heights[r] = maximum_row_heights[r];
                }
            }
            total_height += row_heights[r];
        }
        int total_width = 0;
        for (int c = 0; c < ncols; c++) {
            if (takeSizesIntoAccount) {
                // is not true by clipping to the minimum_col_widths and maximum_col_widths
                if (minimum_col_widths[c] >= maximum_col_widths[c]) {
                    maximum_col_widths[c] = minimum_col_widths[c];
                    col_widths[c] = minimum_col_widths[c];
                } else if (col_widths[c] < minimum_col_widths[c]) {
                    col_widths[c] = minimum_col_widths[c];
                } else if (col_widths[c] > maximum_col_widths[c]) {
                    col_widths[c] = maximum_col_widths[c];
                }
            }
            total_width += col_widths[c];
        }
        // Pass 2: redistribute free space
        Dimension parent_size = parent.getSize();
        Insets insets = parent.getInsets();
        int free_height = parent_size.height - insets.top - insets.bottom - (nrows - 1) * vgap - distanceToBorders.top - distanceToBorders.bottom;
        int free_width = parent_size.width - insets.left - insets.right - (ncols - 1) * hgap - distanceToBorders.left - distanceToBorders.right;
        redistributeSpace(total_height, free_height, takeSizesIntoAccount, nrows, row_heights, minimum_row_heights, maximum_row_heights);
        redistributeSpace(total_width, free_width, takeSizesIntoAccount, ncols, col_widths, minimum_col_widths, maximum_col_widths);
        // Pass 3: layout components
        for (int r = 0, y = insets.top + distanceToBorders.top, i = 0; r < nrows; y += row_heights[r] + vgap, r++) {
            for (int c = 0, x = insets.left + distanceToBorders.left; c < ncols; x += col_widths[c] + hgap, c++, i++) {
                if (i < ncomponents) {
                    Component comp = parent.getComponent(i);
                    Dimension d = comp.getMaximumSize();
                    int width = col_widths[c];
                    int height = row_heights[r];
                    int xCorrection = 0;
                    int yCorrection = 0;
                    if (width > d.width) {
                        xCorrection = (int) ((width - d.width) * comp.getAlignmentX());
                        width = d.width;
                    }
                    if (height > d.height) {
                        yCorrection = (int) ((height - d.height) * comp.getAlignmentY());
                        height = d.height;
                    }
                    comp.setBounds(x + xCorrection, y + yCorrection, width, height);
                }
            }
        }
    }
// synchronized
}