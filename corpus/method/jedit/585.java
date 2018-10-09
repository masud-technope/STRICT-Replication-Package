//}}}
//{{{ save() method
static void save() {
    jEdit.setBooleanProperty("view.expandOnInput", expandOnInput);
    String settings = jEdit.getSettingsDirectory();
    if (abbrevsChanged && settings != null) {
        File file1 = new File(MiscUtilities.constructPath(settings, "#abbrevs#save#"));
        File file2 = new File(MiscUtilities.constructPath(settings, "abbrevs"));
        if (file2.exists() && file2.lastModified() != abbrevsModTime) {
            Log.log(Log.WARNING, Abbrevs.class, file2 + " changed on disk;" + " will not save abbrevs");
        } else {
            jEdit.backupSettingsFile(file2);
            try {
                saveAbbrevs(new OutputStreamWriter(new FileOutputStream(file1), ENCODING));
                file2.delete();
                file1.renameTo(file2);
            } catch (Exception e) {
                Log.log(Log.ERROR, Abbrevs.class, "Error while saving " + file1);
                Log.log(Log.ERROR, Abbrevs.class, e);
            }
            abbrevsModTime = file2.lastModified();
        }
    }
}