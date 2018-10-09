//}}}
//{{{ characters() method
@Override
public void characters(char[] c, int off, int len) {
    String tag = peekElement();
    if (tag.equals("CODE")) {
        code.append(c, off, len);
    } else if (tag.equals("IS_SELECTED")) {
        isSelected.append(c, off, len);
    }
}