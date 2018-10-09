//}}}
//{{{ saveHistory() method
public static void saveHistory() {
    if (saver != null && modified && saver.save(models))
        modified = false;
}