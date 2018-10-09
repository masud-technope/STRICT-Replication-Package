/**
	 * Setter for the "jars" attribute (required if no "jarfileset" is present)
	 */
public void setJars(String s) {
    PatternSet patset = new PatternSet();
    patset.setIncludes(s);
    String[] jarNames = patset.getIncludePatterns(getProject());
    for (int i = 0; i < jarNames.length; i++) mJarAttrs.add(getProject().resolveFile(jarNames[i]));
}