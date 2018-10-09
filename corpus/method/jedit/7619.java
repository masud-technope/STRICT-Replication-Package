/**
	 * Creates a new instance with the given root and the given array
	 * separator character.
	 *
	 * @param root A non-null string that will be the "root" of the
	 *             serialized properties.
	 * @param arraysep A character that will be used to define the
	 *                 separator of elements of an array property.
	 */
protected  PropertiesBean(String root, char arraysep) {
    if (root == null)
        throw new IllegalArgumentException("root cannot be null");
    this.root = root;
    this.arraysep = arraysep;
}