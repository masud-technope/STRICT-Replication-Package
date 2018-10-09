//}}}
//{{{ equals() method
/**
	 * Returns if the specified fold handler is equal to this one.
	 * @param o The object
	 */
public boolean equals(Object o) {
    // Default implementation... subclasses can extend this.
    if (o == null)
        return false;
    else
        return getClass() == o.getClass();
}