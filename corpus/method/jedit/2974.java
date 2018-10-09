//}}}
//{{{ focusBufferSwitcher() method
/**
	 * Pops up and focuses on the buffer switcher combo box.
	 * @since jEdit 4.3pre18
	 * (previously known as showBufferSwitcher)
	 */
public void focusBufferSwitcher() {
    if (bufferSwitcher == null)
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    else {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                bufferSwitcher.requestFocus();
                bufferSwitcher.showPopup();
            }
        });
    }
}