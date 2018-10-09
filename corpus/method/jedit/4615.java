@Override
public boolean save(View view, Buffer buffer, String path) {
    if (OperatingSystem.isUnix()) {
        int permissions = getPermissions(buffer.getPath());
        Log.log(Log.DEBUG, this, buffer.getPath() + " has permissions 0" + Integer.toString(permissions, 8));
        buffer.setIntegerProperty(PERMISSIONS_PROPERTY, permissions);
    }
    return super.save(view, buffer, path);
}