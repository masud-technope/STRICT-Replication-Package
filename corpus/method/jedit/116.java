/**
     * Setter for the "splashfile" attribute (optional). If it is somewhere
     * in a jar file, which contains a Splash-Screen manifest entry,
     * use "$JAVAROOT/myjar.jar"
     */
public void setSplashFile(String s) {
    bundleProperties.setSplashFile(s);
}