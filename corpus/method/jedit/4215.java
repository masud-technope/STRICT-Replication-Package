//}}}
//{{{ removeTrayIcon() method
public static void removeTrayIcon() {
    if (trayIcon != null) {
        SystemTray.getSystemTray().remove(trayIcon);
        if (trayIcon instanceof EBComponent) {
            EditBus.removeFromBus(trayIcon);
        }
        trayIcon = null;
    }
}