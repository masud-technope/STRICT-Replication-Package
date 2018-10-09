//}}}
//{{{ initReplace() method
/**
	 * Set up BeanShell replace if necessary.
	 */
private static void initReplace() throws Exception {
    if (beanshell && replace.length() != 0) {
        String text;
        if (replace.trim().startsWith("{"))
            text = replace;
        else
            text = "return (" + replace + ");";
        replaceMethod = BeanShell.cacheBlock("replace", text, true);
    } else
        replaceMethod = null;
}