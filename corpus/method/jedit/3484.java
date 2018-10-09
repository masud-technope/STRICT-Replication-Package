/**
	  * Returns a hash code value for the object. This method is
	  * supported for the benefit of hashtables such as those provided by
	  * {@code java.util.Hashtable}.
	  * <p>
	  * The general contract of {@code hashCode} is:
	  * <ul>
	  * <li>Whenever it is invoked on the same object more than once during
	  *     an execution of a Java application, the <tt>hashCode</tt> method
	  *     must consistently return the same integer, provided no information
	  *     used in <tt>equals</tt> comparisons on the object is modified.
	  *     This integer need not remain consistent from one execution of an
	  *     application to another execution of the same application.
	  * <li>If two objects are equal according to the <tt>equals(Object)</tt>
	  *     method, then calling the {@code hashCode} method on each of
	  *     the two objects must produce the same integer result.
	  * <li>It is <em>not</em> required that if two objects are unequal
	  *     according to the
	  *     <a href="http://download.oracle.com/javase/6/docs/api/java/lang/Object.html#equals(java.lang.Object)">{@code java.lang.Object#equals(java.lang.Object)}</a>
	  *     method, then calling the <tt>hashCode</tt> method on each of the
	  *     two objects must produce distinct integer results.  However, the
	  *     programmer should be aware that producing distinct integer results
	  *     for unequal objects may improve the performance of hashtables.
	  * </ul>
	  *
	  * @return a hash code value for this object.
	  * @see #equals(java.lang.Object)
	  * @see <a href="http://download.oracle.com/javase/6/docs/api/java/util/Hashtable.html"><code>java.util.Hashtable</code></a>
	  */
public int hashCode() {
    if (null == component) {
        return 0;
    }
    return component.hashCode();
}