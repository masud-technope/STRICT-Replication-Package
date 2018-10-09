@Override
public String constructPath(String parent, String path) {
    if (parent.endsWith(File.separator) || parent.endsWith("/"))
        return parent + path;
    else
        return parent + File.separator + path;
}