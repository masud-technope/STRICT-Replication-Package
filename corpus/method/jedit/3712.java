//{{{ load() method
public Map<String, HistoryModel> load(Map<String, HistoryModel> models) {
    String settingsDirectory = jEdit.getSettingsDirectory();
    if (settingsDirectory == null)
        return models;
    history = new File(MiscUtilities.constructPath(settingsDirectory, "history"));
    if (!history.exists())
        return models;
    historyModTime = history.lastModified();
    Log.log(Log.MESSAGE, HistoryModel.class, "Loading history");
    if (models == null)
        models = Collections.synchronizedMap(new HashMap<String, HistoryModel>());
    BufferedReader in = null;
    try {
        // an old version as well.
        try {
            // Pass the decoder explicitly to report a decode error
            // as an exception instead of replacing with \xFFFD.
            in = new BufferedReader(new InputStreamReader(new FileInputStream(history), Charset.forName("UTF-8").newDecoder()));
            models.putAll(loadFromReader(in));
        } catch (CharacterCodingException e) {
            in.close();
            Log.log(Log.MESSAGE, HistoryModel.class, "Failed to load history with UTF-8." + " Fallbacking to the system default encoding.");
            in = new BufferedReader(new FileReader(history));
            models.putAll(loadFromReader(in));
        }
    } catch (FileNotFoundException fnf) {
    } catch (IOException io) {
        Log.log(Log.ERROR, HistoryModel.class, io);
    } finally {
        IOUtilities.closeQuietly((Closeable) in);
    }
    return models;
}