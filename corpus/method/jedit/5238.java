//}}}
//{{{ isWindows() method
/**
	 * Returns if we're running Windows 95/98/ME/NT/2000/XP/Vista/Win7.
	 */
public static boolean isWindows() {
    return os == WINDOWS_9x || os == WINDOWS_NT;
}