//}}}
//}}}
//}}}
//{{{ Edit modes, syntax highlighting
//{{{ setMode() method
/**
	 * Sets this buffer's edit mode by calling the accept() method
	 * of each registered edit mode.
	 */
public void setMode() {
    Mode mode = null;
    String userMode = getStringProperty("mode");
    if (userMode != null) {
        unsetProperty("mode");
        mode = ModeProvider.instance.getMode(userMode);
    }
    if (mode == null) {
        String firstLine = getLineText(0);
        mode = ModeProvider.instance.getModeForFile(getVFS().getFilePath(path), null, firstLine);
    }
    if (mode != null) {
        int largeBufferSize = jEdit.getIntegerProperty("largeBufferSize", 4000000);
        if (!getFlag(TEMPORARY) && getLength() > largeBufferSize && largeBufferSize > 0) {
            mode.loadIfNecessary();
            boolean contextInsensitive = mode.getBooleanProperty("contextInsensitive");
            String largeFileMode = jEdit.getProperty("largefilemode", "ask");
            if ("ask".equals(largeFileMode)) {
                if (!contextInsensitive) {
                    // the context is not insensitive
                    JTextPane tp = new JTextPane();
                    tp.setEditable(false);
                    tp.setText(jEdit.getProperty("largeBufferDialog.message"));
                    int i = JOptionPane.showOptionDialog(jEdit.getActiveView(), tp, jEdit.getProperty("largeBufferDialog.title", new String[] { name }), JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] { jEdit.getProperty("largeBufferDialog.fullSyntax"), jEdit.getProperty("largeBufferDialog.contextInsensitive"), jEdit.getProperty("largeBufferDialog.defaultMode") }, jEdit.getProperty("largeBufferDialog.contextInsensitive"));
                    switch(i) {
                        case 0:
                            setProperty("largefilemode", "full");
                            setMode(mode);
                            return;
                        case 1:
                            setProperty("largefilemode", "limited");
                            setMode(mode, true);
                            return;
                        case 2:
                            setProperty("largefilemode", "nohighlight");
                            mode = getDefaultMode();
                            setMode(mode);
                            return;
                    }
                }
            } else if ("full".equals(largeFileMode)) {
                setProperty("largefilemode", "full");
                setMode(mode);
            } else if ("limited".equals(largeFileMode)) {
                setProperty("largefilemode", "limited");
                setMode(mode, true);
            } else if ("nohighlight".equals(largeFileMode)) {
                setProperty("largefilemode", "nohighlight");
                mode = getDefaultMode();
                setMode(mode);
            }
        }
        setMode(mode);
        return;
    }
    Mode defaultMode = getDefaultMode();
    if (defaultMode != null)
        setMode(defaultMode);
}