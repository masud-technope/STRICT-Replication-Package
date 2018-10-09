//}}}
//{{{ save() method
public boolean save(Map<String, HistoryModel> models) {
    Log.log(Log.MESSAGE, HistoryModel.class, "Saving history");
    File file1 = new File(MiscUtilities.constructPath(jEdit.getSettingsDirectory(), "#history#save#"));
    File file2 = new File(MiscUtilities.constructPath(jEdit.getSettingsDirectory(), "history"));
    if (file2.exists() && file2.lastModified() != historyModTime) {
        Log.log(Log.WARNING, HistoryModel.class, file2 + " changed on disk; will not save history");
        return false;
    }
    jEdit.backupSettingsFile(file2);
    String lineSep = System.getProperty("line.separator");
    BufferedWriter out = null;
    try {
        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1), "UTF-8"));
        if (models != null) {
            Collection<HistoryModel> values = models.values();
            for (HistoryModel model : values) {
                if (model.getSize() == 0)
                    continue;
                out.write('[');
                out.write(StandardUtilities.charsToEscapes(model.getName(), TO_ESCAPE));
                out.write(']');
                out.write(lineSep);
                for (int i = 0; i < model.getSize(); i++) {
                    out.write(StandardUtilities.charsToEscapes(model.getItem(i), TO_ESCAPE));
                    out.write(lineSep);
                }
            }
        }
        out.close();
        /* to avoid data loss, only do this if the above
			 * completed successfully */
        file2.delete();
        file1.renameTo(file2);
    } catch (IOException io) {
        Log.log(Log.ERROR, HistoryModel.class, io);
    } finally {
        IOUtilities.closeQuietly((Closeable) out);
    }
    historyModTime = file2.lastModified();
    return true;
}