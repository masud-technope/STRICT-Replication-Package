//{{{ setTrayIconArgs() method
public static void setTrayIconArgs(boolean restore, String userDir, String[] args) {
    JTrayIconManager.restore = restore;
    JTrayIconManager.userDir = userDir;
    JTrayIconManager.args = args;
}