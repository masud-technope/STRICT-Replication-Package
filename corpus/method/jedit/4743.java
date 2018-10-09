//}}}
//{{{ dump() method
/**
	 * For debugging.
	 */
public static void dump() {
    Log.log(Log.DEBUG, JARClassLoader.class, "Total instances created: " + INDEX);
    Log.log(Log.DEBUG, JARClassLoader.class, "Live instances: " + live);
    synchronized (classHash) {
        for (Map.Entry<String, Object> entry : classHash.entrySet()) {
            if (entry.getValue() != NO_CLASS) {
                Log.log(Log.DEBUG, JARClassLoader.class, entry.getKey() + " ==> " + entry.getValue());
            }
        }
    }
}