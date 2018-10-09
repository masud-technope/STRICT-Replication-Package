//}}}
//{{{ removeNonCapturingGroups() method
public static Pattern removeNonCapturingGroups(Pattern re, int flags) {
    String p = re.pattern();
    String ncgroups = "[(][?].+?[)]";
    Pattern nc_pattern = Pattern.compile(ncgroups, flags);
    Matcher nc_matcher = nc_pattern.matcher(p);
    if (nc_matcher.find()) {
        int index = nc_matcher.start();
        int open_count = 0;
        for (int i = index; i < p.length(); i++) {
            if (p.charAt(i) == '(' && (i == 0 || p.charAt(i - 1) != '\\')) {
                ++open_count;
            }
            if (p.charAt(i) == ')' && (i == 0 || p.charAt(i - 1) != '\\')) {
                --open_count;
            }
            if (open_count == 0 && i < p.length() - 1) {
                int end = i + 1;
                char c = p.charAt(end);
                if (c == '{') {
                    while (c != '}' && end < p.length() - 1) {
                        ++end;
                        c = p.charAt(end);
                    }
                    ++end;
                }
                c = p.charAt(end);
                if ((c == '?' || c == '+' || c == '*') && end < p.length() - 1) {
                    ++end;
                }
                c = p.charAt(end);
                if ((c == '?' || c == '+') && end < p.length() - 1) {
                    ++end;
                }
                StringBuilder sb = new StringBuilder(p);
                sb.delete(index, end);
                return removeNonCapturingGroups(Pattern.compile(sb.toString(), flags), flags);
            }
        }
    }
    return re;
}