//}}}
//{{{ getNotLoadedPluginJARs() method
private static void getNotLoadedPluginJARs(Collection<String> returnValue, String dir, String[] list) {
    loop: for (String name : list) {
        if (!name.toLowerCase().endsWith(".jar"))
            continue loop;
        String path = MiscUtilities.constructPath(dir, name);
        for (int j = 0; j < jars.size(); j++) {
            PluginJAR jar = jars.elementAt(j);
            String jarPath = jar.getPath();
            if (path.equals(jarPath) || name.equals(MiscUtilities.getFileName(jarPath)) && !new File(jarPath).exists())
                continue loop;
        }
        returnValue.add(path);
    }
}