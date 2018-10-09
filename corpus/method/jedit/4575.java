//}}}
//{{{ _getFile() method
@Override
public VFSFile _getFile(Object session, String path, Component comp) {
    // does it matter that this doesn't set the type correctly?
    return new Favorite(path, VFSFile.DIRECTORY);
}