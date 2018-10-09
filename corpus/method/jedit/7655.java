//}}}
//{{{ objectsEqual() method
/**
	 * Returns if two strings are equal. This correctly handles null pointers,
	 * as opposed to calling <code>o1.equals(o2)</code>.
	 * @since jEdit 4.3pre6
	 * @deprecated use {java.util.Objects#equals(Object, Object}
	 */
@Deprecated
public static boolean objectsEqual(@Nullable Object o1, @Nullable Object o2) {
    if (o1 == null) {
        if (o2 == null)
            return true;
        else
            return false;
    } else if (o2 == null)
        return false;
    else
        return o1.equals(o2);
}