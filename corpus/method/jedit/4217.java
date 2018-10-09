//}}}
//{{{ addTrayIcon() method
public static void addTrayIcon() {
    if (trayIcon == null && SystemTray.isSupported()) {
        SystemTray systemTray = SystemTray.getSystemTray();
        String trayIconName = jEdit.getProperty("systrayicon.service", "swing");
        trayIcon = ServiceManager.getService(JEditTrayIcon.class, trayIconName);
        if (trayIcon == null) {
            if ("swing".equals(trayIconName)) {
                Log.log(Log.ERROR, JTrayIconManager.class, "No service " + JEditTrayIcon.class.getName() + " with name swing");
                return;
            }
            Log.log(Log.WARNING, JTrayIconManager.class, "No service " + JEditTrayIcon.class.getName() + " with name " + trayIconName);
            trayIcon = ServiceManager.getService(JEditTrayIcon.class, "swing");
        }
        if (trayIcon == null) {
            Log.log(Log.ERROR, JTrayIconManager.class, "No service " + JEditTrayIcon.class.getName() + " with name swing");
            return;
        }
        trayIcon.setTrayIconArgs(restore, userDir, args);
        try {
            systemTray.add(trayIcon);
        } catch (AWTException e) {
            Log.log(Log.ERROR, JEditSwingTrayIcon.class, "Unable to add Tray icon", e);
            trayIcon = null;
            return;
        }
        if (trayIcon instanceof EBComponent) {
            EditBus.addToBus(trayIcon);
        }
    }
}