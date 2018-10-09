//}}}
//{{{ characters() method
public void characters(char[] c, int off, int len) {
    peekElement().setText(c, off, len);
}