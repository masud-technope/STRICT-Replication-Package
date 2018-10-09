//}}}
//{{{ actionPerformed() method
@Override
public void actionPerformed(ActionEvent ae) {
    JMenuItem mi = (JMenuItem) ae.getSource();
    String action = mi.getActionCommand();
    String encoding = null;
    Hashtable<String, Object> props = null;
    if (action.startsWith("encoding@")) {
        encoding = action.substring(9);
    } else if ("other-encoding".equals(action)) {
        encoding = JOptionPane.showInputDialog(view, jEdit.getProperty("encoding-prompt.message"), jEdit.getProperty("encoding-prompt.title"), JOptionPane.QUESTION_MESSAGE);
        if (encoding == null)
            return;
        if (!EncodingServer.hasEncoding(encoding)) {
            String msg = jEdit.getProperty("reload-encoding.error", new Object[] { encoding });
            JOptionPane.showMessageDialog(view, msg, jEdit.getProperty("common.error"), JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    if (encoding != null) {
        props = new Hashtable<String, Object>();
        props.put(JEditBuffer.ENCODING, encoding);
        // Disable auto-detect because user explicitly
        // specify an encoding.
        props.put(Buffer.ENCODING_AUTODETECT, false);
        view.getBuffer().setStringProperty(JEditBuffer.ENCODING, encoding);
    }
    String path = view.getBuffer().getPath();
    jEdit.closeBuffer(view, view.getBuffer());
    jEdit.openFile(view, null, path, false, props);
}