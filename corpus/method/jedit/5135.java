public static String expandVariables(String arg) {
    if (arg.startsWith("~/") || arg.startsWith("~\\"))
        return System.getProperty("user.home") + arg.substring(1);
    Matcher m = winPattern.matcher(arg);
    if (!OperatingSystem.isWindows() && m.find())
        return win2unix(arg);
    Pattern p = varPattern;
    m = p.matcher(arg);
    if (!m.find()) {
        if (OperatingSystem.isWindows())
            p = winPattern;
        else
            p = varPattern2;
        m = p.matcher(arg);
        if (!m.find())
            return arg;
    }
    String varName = m.group(2);
    String expansion = System.getenv(varName);
    if (expansion == null) {
        if (varName.equalsIgnoreCase("jedit_settings") && jEdit.getSettingsDirectory() != null) {
            expansion = jEdit.getSettingsDirectory();
        } else {
            varName = varName.toUpperCase();
            String uparg = arg.toUpperCase();
            m = p.matcher(uparg);
            expansion = System.getenv(varName);
        }
    }
    if (expansion != null) {
        expansion = expansion.replace("\\", "\\\\");
        return m.replaceFirst(expansion);
    }
    return arg;
}