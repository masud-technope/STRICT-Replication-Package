/**
	 * Setter for the "extraclasspath" attribute (optional)
	 */
public void setExtraclasspath(String s) {
    if (s == null || s.trim().equals(""))
        return;
    PatternSet patset = new PatternSet();
    patset.setIncludes(s);
    String[] cpNames = patset.getIncludePatterns(getProject());
    for (int i = 0; i < cpNames.length; i++) {
        File f = new File(cpNames[i]);
        mExtraClassPathAttrs.add(f);
    }
}