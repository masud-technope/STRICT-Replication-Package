/**
	 * @param  which  if LayoutSize.MINIMUM compute minimum layout size,
	 *                if LayoutSize.MAXIMUM compute maximum layout size,
	 *                if LayoutSize.PREFERRED compute preferred layout size.
	 */
private Dimension getLayoutSize(Container parent, LayoutSize which) {
    synchronized (parent.getTreeLock()) {
        update(parent);
        int ncomponents = parent.getComponentCount();
        long h = 0;
        long w = 0;
        for (int r = 0, i = 0; r < nrows; r++) {
            int row_height = 0;
            for (int c = 0; c < ncols; c++, i++) {
                if (i < ncomponents) {
                    switch(which) {
                        case MINIMUM:
                            row_height = Math.max(row_height, parent.getComponent(i).getMinimumSize().height);
                            break;
                        case MAXIMUM:
                            row_height = Math.max(row_height, parent.getComponent(i).getMaximumSize().height);
                            break;
                        case PREFERRED:
                            row_height = Math.max(row_height, parent.getComponent(i).getPreferredSize().height);
                            break;
                        default:
                            throw new InternalError("Missing case branch for LayoutSize: " + which);
                    }
                }
            }
            h += row_height;
        }
        for (int c = 0; c < ncols; c++) {
            int col_width = 0;
            for (int r = 0; r < nrows; r++) {
                int i = r * ncols + c;
                if (i < ncomponents) {
                    switch(which) {
                        case MINIMUM:
                            col_width = Math.max(col_width, parent.getComponent(i).getMinimumSize().width);
                            break;
                        case MAXIMUM:
                            col_width = Math.max(col_width, parent.getComponent(i).getMaximumSize().width);
                            break;
                        case PREFERRED:
                            col_width = Math.max(col_width, parent.getComponent(i).getPreferredSize().width);
                            break;
                        default:
                            throw new InternalError("Missing case branch for LayoutSize: " + which);
                    }
                }
            }
            w += col_width;
        }
        Insets insets = parent.getInsets();
        w += insets.left + insets.right + ((ncols - 1) * hgap) + distanceToBorders.left + distanceToBorders.right;
        h += insets.top + insets.bottom + ((nrows - 1) * vgap) + distanceToBorders.top + distanceToBorders.bottom;
        if (w > Integer.MAX_VALUE) {
            w = Integer.MAX_VALUE;
        }
        if (h > Integer.MAX_VALUE) {
            h = Integer.MAX_VALUE;
        }
        return new Dimension((int) w, (int) h);
    }
}