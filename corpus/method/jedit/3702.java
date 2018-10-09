//}}}
//{{{ setModel() method
/**
	 * Sets the model to the given list of objects. The elements of this
	 * array can either be Entry instances, or other objects (if the
	 * latter, they will default to being unchecked).
	 */
public void setModel(Object[] items) {
    setModel(new CheckBoxListModel(items));
    init();
}