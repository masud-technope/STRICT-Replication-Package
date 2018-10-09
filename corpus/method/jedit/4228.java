private void update(Container container) {
    int ncomponents = container.getComponentCount();
    int old_nrows = nrows;
    int old_ncols = ncols;
    if (this.mode == FIXED_NUM_ROWS) {
        nrows = this.size;
        ncols = (ncomponents + nrows - 1) / nrows;
    } else {
        ncols = this.size;
        nrows = (ncomponents + ncols - 1) / ncols;
    }
    if (old_nrows != nrows) {
        row_heights = new int[nrows];
        if (takeSizesIntoAccount) {
            minimum_row_heights = new int[nrows];
            maximum_row_heights = new int[nrows];
        }
    }
    if (old_ncols != ncols) {
        col_widths = new int[ncols];
        if (takeSizesIntoAccount) {
            minimum_col_widths = new int[ncols];
            maximum_col_widths = new int[ncols];
        }
    }
}