//}}}
//{{{ resolveEntity() method
/**
	 * Tries to find the given systemId in the context of the given
	 * class. If the given systemId ends with the given test string,
	 * then try to load a resource using the Class's
	 * <code>getResourceAsStream()</code> method using the test string
	 * as the resource.
	 *
	 * <p>This is used a lot internally while parsing XML files used
	 * by jEdit, but anyone is free to use the method if it sounds
	 * usable.</p>
	 */
public static InputSource findEntity(String systemId, String test, Class<?> where) {
    if (systemId != null && systemId.endsWith(test)) {
        try {
            return new InputSource(new BufferedInputStream(where.getResourceAsStream(test)));
        } catch (Exception e) {
            Log.log(Log.ERROR, XMLUtilities.class, "Error while opening " + test + ':');
            Log.log(Log.ERROR, XMLUtilities.class, e);
        }
    }
    return null;
}