//}}}
//{{{ getKeymapsFromFolder() method
private static Collection<String> getKeymapsFromFolder(File folder) {
    if (folder == null)
        return Collections.emptyList();
    Collection<String> names = new ArrayList<String>();
    File[] files = folder.listFiles(new KeymapFileFilter());
    if (files != null) {
        for (File file : files) {
            String filename = file.getName();
            String name = filename.substring(0, filename.length() - 11);
            names.add(name);
        }
    }
    return names;
}