//}}}
//{{{ show() method
public void show(final DockableWindowManagerImpl.Entry entry) {
    if (entry == null)
        dispose();
    else {
        setTitle(entry.longTitle());
        toFront();
        requestFocus();
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                if (entry.win instanceof DefaultFocusComponent) {
                    ((DefaultFocusComponent) entry.win).focusOnDefaultComponent();
                } else {
                    entry.win.requestFocus();
                }
            }
        });
    }
}