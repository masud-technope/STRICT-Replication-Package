//}}}
//}}}
//{{{ hideSplashScreen() method
/**
	 * Ensures that the splash screen is not visible. This should be
	 * called before displaying any dialog boxes or windows at
	 * startup.
	 */
public static void hideSplashScreen() {
    if (splash != null) {
        splash.dispose();
        splash = null;
    }
}