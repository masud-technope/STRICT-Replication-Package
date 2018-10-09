//}}}
//{{{ fileLength() method
/**
	 * Returns the length of a file. If it is a directory it will calculate recursively the length.
	 *
	 * @param file the file or directory
	 * @return the length of the file or directory. If the file doesn't exist it will return 0
	 * @since 4.3pre10
	 */
public static long fileLength(File file) {
    long length = 0L;
    if (file.isFile())
        length = file.length();
    else if (file.isDirectory()) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) length += fileLength(f);
        }
    }
    return length;
}