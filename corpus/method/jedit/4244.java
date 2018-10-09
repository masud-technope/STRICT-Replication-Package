//}}}
//{{{ showSplashScreen() method
static void showSplashScreen() {
    // Have to do it in the EDT, since it creates gui components
    try {
        SwingUtilities.invokeAndWait(new Runnable() {

            public void run() {
                splash = new SplashScreen();
            }
        });
    } catch (Exception e) {
        Log.log(Log.ERROR, GUIUtilities.class, "error displaying splash screen !", e);
    }
}