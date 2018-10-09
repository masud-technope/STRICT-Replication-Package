//{{{ getEntry() method
public Entry getEntry(String classname) {
    if (classname == null || classname.isEmpty())
        return null;
    for (Entry entry : entries) {
        if (classname.equals(entry.clazz))
            return entry;
    }
    return null;
//}}}
}