//}}}
//{{{ requestFocus() method
/**
	 * Focuses on the specified component as soon as the window becomes
	 * active.
	 * @param win The window
	 * @param comp The component
	 * @since jEdit 5.3.1
	 */
public static void requestFocus(final Window win, final Component comp) {
    win.addWindowFocusListener(new WindowAdapter() {

        @Override
        public void windowGainedFocus(WindowEvent evt) {
            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    comp.requestFocusInWindow();
                }
            });
            win.removeWindowFocusListener(this);
        }
    });
}