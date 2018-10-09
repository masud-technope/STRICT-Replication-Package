/**
	 * Setter for the "execs" attribute (optional)
	 */
public void setExecs(String s) {
    PatternSet patset = new PatternSet();
    patset.setIncludes(s);
    String[] execNames = patset.getIncludePatterns(getProject());
    for (int i = 0; i < execNames.length; i++) {
        File f = new File(execNames[i]);
        mExecAttrs.add(f);
    }
}