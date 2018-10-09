/**
	  * Indicates whether some other object is "equal to" this one.
	  * <p>
	  * The {@code equals} method implements an equivalence relation
	  * on non-null object references:
	  * <ul>
	  * <li>It is <i>reflexive</i>: for any non-null reference value
	  *     {@code x}, {@code x.equals(x)} returns
	  *     {@code true}.
	  * <li>It is <i>symmetric</i>: for any non-null reference values
	  *     {@code x} and {@code y}, {@code x.equals(y)}
	  *     returns {@code true} if and only if
	  *     {@code y.equals(x)} returns {@code true}.
	  * <li>It is <i>transitive</i>: for any non-null reference values
	  *     {@code x}, {@code y}, and {@code z}, if
	  *     {@code x.equals(y)} returns {@code true} and
	  *     {@code y.equals(z)} returns {@code true}, then
	  *     {@code x.equals(z)} returns {@code true}.
	  * <li>It is <i>consistent</i>: for any non-null reference values
	  *     {@code x} and {@code y}, multiple invocations of
	  *     <tt>x.equals(y)</tt> consistently return {@code true}
	  *     or consistently return {@code false}, provided no
	  *     information used in {@code equals} comparisons on the
	  *     objects is modified.
	  * <li>For any non-null reference value {@code x},
	  *     {@code x.equals(null)} returns {@code false}.
	  * </ul>
	  * <p>
	  * The <tt>equals</tt> method for class
	  * {@code ExtendedGridLayoutConstraints} returns {@code true}
	  * if and only if the constraints objects describe the same {@code Component}
	  *
	  * @param o the reference object with which to compare.
	  * @return {@code true} if this object is the same as the o
	  *         argument; {@code false} otherwise.
	  * @see #hashCode()
	  * @see <a href="http://download.oracle.com/javase/6/docs/api/java/util/Hashtable.html"><code>java.util.Hashtable</code></a>
	  */
public boolean equals(Object o) {
    if ((o == null) || (!(o instanceof ExtendedGridLayoutConstraints))) {
        return false;
    }
    if (component == null) {
        return ((ExtendedGridLayoutConstraints) o).component == null;
    }
    return component.equals(((ExtendedGridLayoutConstraints) o).component);
}