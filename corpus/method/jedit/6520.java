//}}}
//{{{ getNoWordSep() method
public String getNoWordSep() {
    if (_noWordSep == null) {
        _noWordSep = noWordSep;
        if (noWordSep == null)
            noWordSep = "";
        if (keywords != null)
            noWordSep += keywords.getNonAlphaNumericChars();
    }
    return noWordSep;
}