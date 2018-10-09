//}}}
//{{{ loadHistory() method
public static void loadHistory() {
    if (saver != null)
        models = saver.load(models);
}