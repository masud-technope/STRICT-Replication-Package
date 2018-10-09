//}}}
//{{{ regexpReplace() method
private static String regexpReplace(SearchMatcher.Match occur, CharSequence found) throws Exception {
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < replace.length(); i++) {
        char ch = replace.charAt(i);
        switch(ch) {
            case '$':
                if (i == replace.length() - 1) {
                    // last character of the replace string, 
                    // it is not a capturing group
                    buf.append(ch);
                    break;
                }
                ch = replace.charAt(++i);
                if (ch == '$') {
                    // It was $$, so it is an escaped $
                    buf.append('$');
                } else if (ch == '0') {
                    // $0 meaning the first capturing group :
                    // the found value
                    buf.append(found);
                } else if (Character.isDigit(ch)) {
                    int n = ch - '0';
                    while (i < replace.length() - 1) {
                        ch = replace.charAt(++i);
                        if (Character.isDigit(ch)) {
                            n = n * 10 + (ch - '0');
                        } else {
                            // The character is not 
                            // a digit, going back and
                            // end loop
                            i--;
                            break;
                        }
                    }
                    if (n < occur.substitutions.length) {
                        String subs = occur.substitutions[n];
                        if (subs != null)
                            buf.append(subs);
                    }
                }
                break;
            case '\\':
                if (i == replace.length() - 1) {
                    buf.append('\\');
                    break;
                }
                ch = replace.charAt(++i);
                switch(ch) {
                    case 'n':
                        buf.append('\n');
                        break;
                    case 't':
                        buf.append('\t');
                        break;
                    default:
                        buf.append(ch);
                        break;
                }
                break;
            default:
                buf.append(ch);
                break;
        }
    }
    return buf.toString();
}