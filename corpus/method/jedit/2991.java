//}}}
//{{{ focusOnTextArea() method
/**
	 * Sets the focus onto the text area.
	 * @since jEdit 2.5pre2
	 */
public void focusOnTextArea() {
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            textArea.requestFocus();
        }
    });
}