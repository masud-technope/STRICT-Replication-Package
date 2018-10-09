//}}}
//{{{ logAdvanceTime() method
private void logAdvanceTime(String label) {
    long currentTime = System.currentTimeMillis();
    if (lastLabel != null) {
        Log.log(Log.DEBUG, SplashScreen.class, lastLabel + ':' + (currentTime - lastAdvanceTime) + "/" + (currentTime - firstAdvanceTime) + "ms");
    }
    if (label != null) {
        lastLabel = label;
        lastAdvanceTime = currentTime;
    }
}