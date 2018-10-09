//{{{ characters() method
@Override
public void characters(char[] c, int off, int len) {
    String tag = peekElement();
    if (tag.equals("DOCKABLE"))
        code.append(c, off, len);
//}}}
}