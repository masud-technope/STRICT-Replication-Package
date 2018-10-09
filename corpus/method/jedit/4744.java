//}}}
//{{{ getResourceAsPath() method
/**
	 * construct a jeditresource:/etc path from the name
	 * of a resource in the associated jar.
	 * The existence of the resource is not actually checked.
	 *
	 * @param name name of the resource
	 * @return jeditresource:/path_to_the_jar!name_of_the_resource
	 * @throws UnsupportedOperationException if this is an anonymous
	 * JARClassLoader (no associated jar).
	 */
public String getResourceAsPath(String name) {
    // this must be fixed during plugin development
    if (jar == null)
        throw new UnsupportedOperationException("don't call getResourceAsPath() on anonymous JARClassLoader");
    if (!name.startsWith("/"))
        name = '/' + name;
    return "jeditresource:/" + MiscUtilities.getFileName(jar.getPath()) + '!' + name;
}