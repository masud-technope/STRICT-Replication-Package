//}}}
//{{{ characters() method
public void characters(char[] c, int off, int len) {
    String tag = peekElement();
    if (tag == "SERVICE")
        code.append(c, off, len);
}