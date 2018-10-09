@Override
public void mouseClicked(MouseEvent e) {
    if (e.getButton() != MouseEvent.BUTTON1)
        return;
    if (jEdit.getViewCount() == 0) {
        EditServer.handleClient(restore, true, false, userDir, args);
    } else {
        boolean newVisibilityState = !jEdit.getActiveView().isVisible();
        if (newVisibilityState) {
            for (Window window : Window.getOwnerlessWindows()) {
                if (skipWindow(window))
                    continue;
                Boolean previousState = windowState.get(window);
                if (previousState == null)
                    window.setVisible(true);
                else if (previousState)
                    window.setVisible(previousState);
            }
            windowState.clear();
            if (jEdit.getActiveView().getState() == Frame.ICONIFIED)
                jEdit.getActiveView().setState(Frame.NORMAL);
            jEdit.getActiveView().toFront();
        } else {
            for (Window window : Window.getOwnerlessWindows()) {
                if (skipWindow(window))
                    continue;
                windowState.put(window, window.isVisible());
                window.setVisible(false);
            }
        }
    }
}