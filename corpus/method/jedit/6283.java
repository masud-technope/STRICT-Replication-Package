//}}}
//{{{ replaceOne() method
private static String replaceOne(View view, JEditBuffer buffer, SearchMatcher.Match occur, CharSequence found) throws Exception {
    if (regexp) {
        if (replaceMethod != null)
            return regexpBeanShellReplace(view, buffer, occur);
        else
            return regexpReplace(occur, found);
    } else {
        if (replaceMethod != null)
            return literalBeanShellReplace(view, buffer, found);
        else
            return replace;
    }
}