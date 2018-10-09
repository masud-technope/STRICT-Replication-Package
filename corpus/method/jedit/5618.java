//}}}
//{{{ removePluginCache() method
private void removePluginCache() {
    if (cachePath != null)
        new File(cachePath).delete();
}