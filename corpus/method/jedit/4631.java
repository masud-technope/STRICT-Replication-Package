//}}}
//{{{ constructPath() method
public String constructPath(String parent, String path) {
    if (parent.endsWith("/"))
        return parent + path;
    else
        return parent + '/' + path;
}