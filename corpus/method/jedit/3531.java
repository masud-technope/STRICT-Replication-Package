//}}}
/**
	 * This fine grain notification tells listeners the exact range
	 * of cells, rows, or columns that changed.
	 */
@Override
public void tableChanged(TableModelEvent e) {
    setFilter(filter);
}