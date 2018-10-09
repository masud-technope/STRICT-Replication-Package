//}}}
//{{{ getModeForFile() method
/**
	 * Get the appropriate mode that must be used for the file
	 * @param filename the filename
	 * @param firstLine the first line of the file
	 * @return the edit mode, or null if no mode match the file
	 * @since jEdit 4.3pre12
	 */
public Mode getModeForFile(String filename, String firstLine) {
    return getModeForFile(null, filename, firstLine);
}