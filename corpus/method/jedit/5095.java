//}}}
//{{{ classToFile() method
/**
	 * Converts a class name to a file name. All periods are replaced
	 * with slashes and the '.class' extension is added.
	 * @param name The class name
	 */
public static String classToFile(String name) {
    return name.replace('.', '/').concat(".class");
}