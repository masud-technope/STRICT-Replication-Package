private String getLayoutDirectory() {
    String name = getName();
    if (name == null)
        return null;
    String dir = jEdit.getSettingsDirectory();
    if (dir == null)
        return null;
    dir = dir + File.separator + name;
    File d = new File(dir);
    if (!d.exists())
        d.mkdir();
    return dir;
}