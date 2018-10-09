//{{{ getVersion() method
/**
	 * Returns the jEdit version as a human-readable string.
	 */
public static String getVersion() {
    return MiscUtilities.buildToVersion(getBuild());
}