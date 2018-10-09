//}}}
//{{{ _listFiles() method
public VFSFile[] _listFiles(Object session, String url, Component comp) {
    File[] roots = listRoots();
    if (roots == null)
        return null;
    VFSFile[] rootDE = new VFSFile[roots.length];
    for (int i = 0; i < roots.length; i++) rootDE[i] = new Root(roots[i]);
    return rootDE;
}