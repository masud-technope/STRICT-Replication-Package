//{{{ characters() method
public void characters(char[] c, int off, int len) {
    if (tag.equals("TITLE")) {
        boolean firstNonWhitespace = false;
        for (int i = 0; i < len; i++) {
            char ch = c[off + i];
            if (!firstNonWhitespace && Character.isWhitespace(ch))
                continue;
            firstNonWhitespace = true;
            title.append(ch);
        }
    }
//}}}
}