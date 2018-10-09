 VarCompressor() {
    ProcessBuilder pb = new ProcessBuilder();
    Map<String, String> env = pb.environment();
    if (OperatingSystem.isUnix())
        prefixMap.put(System.getProperty("user.home"), "~");
    if (jEdit.getSettingsDirectory() != null)
        prefixMap.put(jEdit.getSettingsDirectory(), "JEDIT_SETTINGS");
    for (Map.Entry<String, String> entry : env.entrySet()) {
        String k = entry.getKey();
        if (k.equalsIgnoreCase("pwd") || k.equalsIgnoreCase("oldpwd"))
            continue;
        if (!Character.isLetter(k.charAt(0)))
            continue;
        String v = entry.getValue();
        if (!canBePathPrefix(v))
            continue;
        if (v.endsWith(File.separator))
            v = v.substring(0, v.length() - 1);
        if (OperatingSystem.isWindows())
            if (k.length() + 2 > v.length())
                continue;
            else if (k.length() + 1 > v.length())
                continue;
        if (OperatingSystem.isWindows()) {
            v = v.toLowerCase();
            k = k.toLowerCase();
        }
        if (prefixMap.containsKey(v)) {
            String otherKey = prefixMap.get(v);
            if (otherKey.length() < k.length())
                continue;
        }
        prefixMap.put(v, k);
    }
}