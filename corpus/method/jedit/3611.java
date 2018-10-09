//}}}
//{{{ getModel() method
/**
	 * Returns a named model. If the specified model does not
	 * already exist, it will be created.
	 * @param name The model name
	 */
public static HistoryModel getModel(String name) {
    if (models == null)
        models = Collections.synchronizedMap(new HashMap<String, HistoryModel>());
    HistoryModel model = models.get(name);
    if (model == null) {
        model = new HistoryModel(name);
        models.put(name, model);
    }
    return model;
}