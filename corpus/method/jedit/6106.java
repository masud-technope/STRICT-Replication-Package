//}}}
//{{{ getCode() method
/**
	 * Returns the BeanShell code that will recreate this file set.
	 * @since jEdit 2.7pre3
	 */
@Override
public String getCode() {
    return "new AllBufferSet(\"" + StandardUtilities.charsToEscapes(glob) + "\", view)";
}