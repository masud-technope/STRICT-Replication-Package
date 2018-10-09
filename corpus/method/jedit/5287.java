//}}}
//}}}
//{{{ setFileFlag() method
private void setFileFlag(String fileName, boolean present) {
    String settingsDirectory = jEdit.getSettingsDirectory();
    if (settingsDirectory != null) {
        File file = new File(settingsDirectory, fileName);
        if (!present) {
            file.delete();
        } else {
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(file);
                out.write('\n');
                out.close();
            } catch (IOException io) {
                Log.log(Log.ERROR, this, io);
            } finally {
                IOUtilities.closeQuietly(out);
            }
        }
    }
}