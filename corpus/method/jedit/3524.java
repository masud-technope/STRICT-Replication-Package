//}}}
//{{{ setList() method
/**
	 * Set the JList that uses this model.
	 * It is used to restore the selection after the filter has been applied
	 * If it is null,
	 *
	 * @param list the list that uses the model
	 */
public void setList(JList<?> list) {
    if (list.getModel() != this)
        throw new IllegalArgumentException("The given list " + list + " doesn't use this model " + this);
    this.list = list;
}