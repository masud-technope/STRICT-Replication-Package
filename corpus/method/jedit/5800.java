//}}}
//{{{ handlePluginUpdate() method
@EBHandler
public void handlePluginUpdate(PluginUpdate msg) {
    if (!queuedUpdate) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                queuedUpdate = false;
                manager.update();
            }
        });
        queuedUpdate = true;
    }
}