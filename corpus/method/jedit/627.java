//}}}
//{{{ attribute() method
public void attribute(String aname, String value, boolean isSpecified) {
    aname = (aname == null) ? null : aname.intern();
    value = (value == null) ? null : value.intern();
    if ("NAME".equals(aname))
        actionName = value;
    else if ("NO_REPEAT".equals(aname))
        noRepeat = ("TRUE".equals(value));
    else if ("NO_RECORD".equals(aname))
        noRecord = ("TRUE".equals(value));
    else if ("NO_REMEMBER_LAST".equals(aname))
        noRememberLast = ("TRUE".equals(value));
}