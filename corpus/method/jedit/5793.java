//}}}
//{{{ attribute() method
public void attribute(String aname, String value, boolean isSpecified) {
    if (aname == "NAME")
        name = value;
    else if (aname == "JAR")
        jar = value;
    else if (aname == "VERSION")
        version = value;
    else if (aname == "DATE")
        date = value;
    else if (aname == "OBSOLETE")
        obsolete = ("TRUE".equals(value));
    else if (aname == "WHAT")
        depWhat = value;
    else if (aname == "FROM")
        depFrom = value;
    else if (aname == "TO")
        depTo = value;
    else if (aname == "PLUGIN")
        depPlugin = value;
    else if (aname == "SIZE") {
        size = Integer.parseInt(value);
        if (size == 0)
            Log.log(Log.WARNING, this, "SIZE = 0");
    }
}