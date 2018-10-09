//}}}
//{{{ newInstance() method
/**
	 * Creates a new instance of the tree cell renderer. Each invocation has to
	 * return a different object. Saving a reference and returning the same
	 * instance from different calls of this method is <b>not</b> appropriate.
	 * <p>
	 * Any one-time initializations that are necessary and are not made in the
	 * constructor should be made in this method. The simplest implementation
	 * of this method will just call the constructor and return the result.
	 * <p>
	 * This is an instance method so that the new instance can be set up with
	 * information from the current instance.
	 *
	 * @return a new readily initialized instance of this class
	 */
protected abstract TreeCellRenderer newInstance();