//}}}
//{{{ startPluginLater() method
private void startPluginLater() {
    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            if (!activated)
                return;
            startPlugin();
        }
    });
}