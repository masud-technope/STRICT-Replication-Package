//}}}
//{{{ getDefaultColorFor() method
/**
	 * Returns color of the specified file name, by matching it against
	 * user-specified regular expressions.
	 * @since jEdit 4.0pre1
	 */
public static Color getDefaultColorFor(String name) {
    synchronized (lock) {
        if (colors == null)
            loadColors();
        for (ColorEntry entry : colors) {
            if (entry.re.matcher(name).matches())
                return entry.color;
        }
        return null;
    }
}