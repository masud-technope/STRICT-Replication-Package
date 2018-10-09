//}}}
//{{{ isMacOSLF() method
/**
	* Returns if we're running MacOS X and using the native look and feel.
	*/
public static boolean isMacOSLF() {
    return isMacOS() && UIManager.getLookAndFeel().isNativeLookAndFeel();
}