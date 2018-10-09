//{{{ loadFromReader() method
private static Map<String, HistoryModel> loadFromReader(BufferedReader in) throws IOException {
    Map<String, HistoryModel> result = new HashMap<String, HistoryModel>();
    HistoryModel currentModel = null;
    String line;
    while ((line = in.readLine()) != null) {
        if (line.length() > 0 && line.charAt(0) == '[' && line.charAt(line.length() - 1) == ']') {
            if (currentModel != null) {
                result.put(currentModel.getName(), currentModel);
            }
            String modelName = MiscUtilities.escapesToChars(line.substring(1, line.length() - 1));
            currentModel = new HistoryModel(modelName);
        } else if (currentModel == null) {
            throw new IOException("History data starts" + " before model name");
        } else {
            currentModel.addElement(MiscUtilities.escapesToChars(line));
        }
    }
    if (currentModel != null) {
        result.put(currentModel.getName(), currentModel);
    }
    return result;
}