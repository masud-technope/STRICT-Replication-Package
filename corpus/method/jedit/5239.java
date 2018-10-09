//}}}
//{{{ isDOSDerived() method
/**
	 * Returns if we're running Windows 95/98/ME/NT/2000/XP/Vista/Win7, or OS/2.
	 * @deprecated use {@link #isWindows()}
	 */
@Deprecated
public static boolean isDOSDerived() {
    return isWindows() || isOS2();
}