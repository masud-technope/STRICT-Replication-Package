//}}}
//{{{ isX11() method
/**
	 * Returns if this OS is likely to be using X11 as the graphics
	 * system.
	 * @since jEdit 4.2pre3
	 */
public static boolean isX11() {
    return os == UNIX;
}