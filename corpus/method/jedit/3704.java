/**
	 * Creates a checkbox list with the given list of objects. The elements
	 * of this array can either be Entry instances, or other objects (if the
	 * latter, they will default to being unchecked).
	 */
public  JCheckBoxList(Object[] items) {
    setModel(items);
}