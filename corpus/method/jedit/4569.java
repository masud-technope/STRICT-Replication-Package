//}}}
//{{{ _listFiles() method
@Override
public VFSFile[] _listFiles(Object session, String url, Component comp) {
    return getFavorites();
}