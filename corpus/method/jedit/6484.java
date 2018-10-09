//}}}
//{{{ getModeForFile() method
/**
	 * Get the appropriate mode that must be used for the file
	 * @param filepath the filepath, can be {@code null}
	 * @param filename the filename, can be {@code null}
	 * @param firstLine the first line of the file
	 * @return the edit mode, or null if no mode match the file
	 * @since jEdit 4.5pre1
	 */
public Mode getModeForFile(String filepath, String filename, String firstLine) {
    if (filepath != null && filepath.endsWith(".gz"))
        filepath = filepath.substring(0, filepath.length() - 3);
    if (filename != null && filename.endsWith(".gz"))
        filename = filename.substring(0, filename.length() - 3);
    List<Mode> acceptable = new ArrayList<Mode>(1);
    for (Mode mode : modes.values()) {
        if (mode.accept(filepath, filename, firstLine)) {
            acceptable.add(mode);
        }
    }
    if (acceptable.size() == 1) {
        return acceptable.get(0);
    }
    if (acceptable.size() > 1) {
        // The check should be in reverse order so that
        // modes from the user catalog get checked first!
        Collections.reverse(acceptable);
        // expression but which is identical
        for (Mode mode : acceptable) {
            if (mode.acceptIdentical(filepath, filename)) {
                return mode;
            }
        }
        // filepath and the first line glob
        for (Mode mode : acceptable) {
            if (mode.acceptFile(filepath, filename) && mode.acceptFirstLine(firstLine)) {
                return mode;
            }
        }
        // next best is filepath match, there could be multiple matches,
        // need to choose the best one
        List<Mode> filepathMatch = new ArrayList<Mode>();
        for (Mode mode : acceptable) {
            if (mode.acceptFile(filepath, filename)) {
                filepathMatch.add(mode);
            }
        }
        if (filepathMatch.size() == 1) {
            return filepathMatch.get(0);
        } else if (filepathMatch.size() > 1) {
            // return the one with the longest glob pattern since that one
            // is most likely to be more specific and hence the best choice
            Mode longest = filepathMatch.get(0);
            for (Mode mode : filepathMatch) {
                if (((String) mode.getProperty("filenameGlob")).length() > ((String) longest.getProperty("filenameGlob")).length()) {
                    longest = mode;
                }
            }
            return longest;
        }
        // they all match, so just return the first one.
        return acceptable.get(0);
    }
    // no matching mode found for this file
    return null;
}