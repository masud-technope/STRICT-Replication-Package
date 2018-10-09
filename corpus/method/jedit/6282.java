//}}}
//{{{ regexpBeanShellReplace() method
private static String regexpBeanShellReplace(View view, JEditBuffer buffer, SearchMatcher.Match occur) throws Exception {
    replaceNS.setVariable("buffer", buffer, false);
    for (int i = 0; i < occur.substitutions.length; i++) {
        replaceNS.setVariable("_" + i, occur.substitutions[i]);
    }
    Object obj = BeanShell.runCachedBlock(replaceMethod, view, replaceNS);
    for (int i = 0; i < occur.substitutions.length; i++) {
        replaceNS.setVariable("_" + i, null, false);
    }
    // Not really necessary because it is already cleared in the end of
    // BeanShell.runCachedBlock()
    replaceNS.setVariable("buffer", null, false);
    if (obj == null)
        return "";
    else
        return obj.toString();
}