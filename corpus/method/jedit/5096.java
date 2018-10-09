//}}}
//{{{ fileToClass() method
/**
	 * Converts a file name to a class name. All slash characters are
	 * replaced with periods and the trailing '.class' is removed.
	 * @param name The file name
	 */
public static String fileToClass(String name) {
    char[] clsName = name.toCharArray();
    for (int i = clsName.length - 6; i >= 0; i--) if (clsName[i] == '/')
        clsName[i] = '.';
    return new String(clsName, 0, clsName.length - 6);
}