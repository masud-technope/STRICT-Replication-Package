//}}}
//{{{ save() method
@Override
public void save() {
    if (modified) {
        modified = false;
        File userKeymapFile = KeymapManagerImpl.getUserKeymapFile(name);
        userKeymapFile.getParentFile().mkdirs();
        BufferedOutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream(userKeymapFile));
            MiscUtilities.storeProperties(props, out, "jEdit's keymap " + name);
        } catch (IOException e) {
            Log.log(Log.ERROR, this, "Unable to save properties", e);
        } finally {
            IOUtilities.closeQuietly((Closeable) out);
        }
    }
}