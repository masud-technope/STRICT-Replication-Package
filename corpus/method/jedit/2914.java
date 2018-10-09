//}}}
//{{{ toString() method
/**
	 * Returns a string representation of this message.
	 */
@Override
public String toString() {
    String className = getClass().getName();
    int index = className.lastIndexOf('.');
    return className.substring(index + 1) + '[' + paramString() + ']';
}