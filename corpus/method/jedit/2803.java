//}}}
//{{{ load() method
public static void load() {
    if (recentXML == null)
        return;
    if (!recentXML.fileExists())
        return;
    Log.log(Log.MESSAGE, BufferHistory.class, "Loading " + recentXML);
    RecentHandler handler = new RecentHandler();
    try {
        recentXML.load(handler);
    } catch (IOException e) {
        Log.log(Log.ERROR, BufferHistory.class, e);
    }
    trimToLimit(handler.result);
    history = handler.result;
}