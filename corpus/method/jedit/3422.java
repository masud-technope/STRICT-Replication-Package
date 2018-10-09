//}}}
//{{{ getAbbrev() method
public String getAbbrev() {
    if (!isOK)
        return null;
    return editor.getAbbrev();
}