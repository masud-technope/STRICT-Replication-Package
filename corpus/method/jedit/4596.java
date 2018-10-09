@Override
public void _saveComplete(Object session, Buffer buffer, String path, Component comp) {
    int permissions = buffer.getIntegerProperty(PERMISSIONS_PROPERTY, 0);
    setPermissions(path, permissions);
}