//}}}
//{{{ copyKeymap() method
@Override
public boolean copyKeymap(String name, String newName) {
    Log.log(Log.DEBUG, this, "copyKeymap(" + name + ',' + newName + ')');
    File keymapFile = getUserKeymapFile(newName);
    if (keymapFile.exists())
        throw new IllegalArgumentException("Keymap " + newName + " already exists");
    File originalKeymap = getKeymapFile(name);
    if (!originalKeymap.isFile())
        throw new IllegalArgumentException("Keymap " + name + " doesn't exist");
    keymapFile.getParentFile().mkdirs();
    BufferedInputStream in = null;
    BufferedOutputStream out = null;
    Log.log(Log.DEBUG, this, "Copying " + originalKeymap.getAbsolutePath() + " to " + keymapFile.getAbsolutePath());
    try {
        in = new BufferedInputStream(new FileInputStream(originalKeymap));
        out = new BufferedOutputStream(new FileOutputStream(keymapFile));
        IOUtilities.copyStream(null, in, out, false);
        return true;
    } catch (IOException e) {
        Log.log(Log.ERROR, this, e);
    } finally {
        IOUtilities.closeQuietly((Closeable) in);
        IOUtilities.closeQuietly((Closeable) out);
    }
    return false;
}