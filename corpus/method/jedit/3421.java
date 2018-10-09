//}}}
//{{{ getExpansion() method
public String getExpansion() {
    if (!isOK)
        return null;
    return editor.getExpansion();
}