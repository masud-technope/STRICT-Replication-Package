private static String literalBeanShellReplace(View view, JEditBuffer buffer, CharSequence found) throws Exception {
    replaceNS.setVariable("buffer", buffer);
    replaceNS.setVariable("_0", found);
    Object obj = BeanShell.runCachedBlock(replaceMethod, view, replaceNS);
    replaceNS.setVariable("_0", null, false);
    replaceNS.setVariable("buffer", null, false);
    if (obj == null)
        return "";
    else
        return obj.toString();
}