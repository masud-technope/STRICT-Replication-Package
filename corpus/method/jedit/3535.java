//}}}
//{{{ passFilter() method
/**
	 * This callback indicates if a row passes the filter.
	 *
	 * @param row    the row number the delegate row count
	 * @param filter the filter string
	 * @return true if the row must be visible
	 */
public abstract boolean passFilter(int row, String filter);