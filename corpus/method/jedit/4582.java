//}}}
//{{{ _getFile() method
public VFSFile _getFile(Object session, String path, Component comp) {
    return new Root(new File(path));
}