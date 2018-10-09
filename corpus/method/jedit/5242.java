//}}}
//{{{ isUnix() method
/**
	 * Returns if we're running Unix (this includes MacOS X).
	 */
public static boolean isUnix() {
    return os == UNIX || os == MAC_OS_X;
}