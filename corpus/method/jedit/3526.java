//}}}
//{{{ setTable() method
/**
	 * Set the JTable that uses this model.
	 * It is used to restore the selection after the filter has been applied
	 * If it is null,
	 *
	 * @param table the table that uses the model
	 */
public void setTable(JTable table) {
    if (table.getModel() != this)
        throw new IllegalArgumentException("The given table " + table + " doesn't use this model " + this);
    this.table = table;
}