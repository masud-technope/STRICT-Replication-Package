//}}}
//{{{ init() method
/**
	 * Initializes the edit mode. Should be called after all properties
	 * are loaded and set.
	 */
public void init() {
    try {
        filepathMatcher = null;
        String filenameGlob = (String) getProperty("filenameGlob");
        if (filenameGlob != null && !filenameGlob.isEmpty()) {
            // translate glob to regex
            String filepathRE = StandardUtilities.globToRE(filenameGlob);
            // Windows paths in there)
            if (filepathRE.contains("/") || filepathRE.contains("\\\\")) {
                filepathRE = filepathRE.replaceAll("/|\\\\\\\\", "[/\\\\\\\\]");
            } else {
                filepathRE = String.format("(?:.*[/\\\\])?%s", filepathRE);
            }
            this.filepathMatcher = Pattern.compile(filepathRE, Pattern.CASE_INSENSITIVE).matcher("");
        }
        firstlineMatcher = null;
        String firstlineGlob = (String) getProperty("firstlineGlob");
        if (firstlineGlob != null && !firstlineGlob.isEmpty()) {
            firstlineMatcher = Pattern.compile(StandardUtilities.globToRE(firstlineGlob), Pattern.CASE_INSENSITIVE).matcher("");
        }
    } catch (PatternSyntaxException re) {
        Log.log(Log.ERROR, this, "Invalid filename/firstline" + " globs in mode " + name);
        Log.log(Log.ERROR, this, re);
    }
    marker = null;
}