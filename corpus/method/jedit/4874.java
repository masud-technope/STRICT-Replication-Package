//}}}
//{{{ logTime(String) method
/** Logs time since startup, for benchmarking */
private static void logTime(String label) {
    long currentTime = System.currentTimeMillis();
    Log.log(Log.DEBUG, jEdit.class, label + ':' + (currentTime - startupTime) + " ms");
}