/**
	 * Creates a checkbox list with the given list of objects. The elements
	 * of this vector can either be Entry instances, or other objects (if the
	 * latter, they will default to being unchecked).
	 */
public  JCheckBoxList(Vector items) {
    setModel(items);
}