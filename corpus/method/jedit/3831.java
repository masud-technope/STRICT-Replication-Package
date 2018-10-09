//}}}
//{{{ showMostRecent() method
public void showMostRecent() {
    if (dockables.isEmpty()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    if (mostRecent == null) {
        mostRecent = dockables.get(0).factory.name;
    }
    wm.showDockableWindow(mostRecent);
}