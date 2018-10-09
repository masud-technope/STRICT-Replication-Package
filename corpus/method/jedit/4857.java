//}}}
//{{{ initPLAF() method
/**
	 * Sets the Swing look and feel.
	 */
private static void initPLAF() {
    String lf = getProperty("lookAndFeel");
    final String sLf = getPLAFClassName(lf);
    String sLfOld = null;
    String sLfNew = null;
    LookAndFeel lfOld = UIManager.getLookAndFeel();
    if (lfOld != null)
        sLfOld = lfOld.getClass().getName();
    Font primaryFont = jEdit.getFontProperty("metal.primary.font");
    if (primaryFont != null) {
        String primaryFontString = fontToString(primaryFont);
        System.getProperties().put("swing.plaf.metal.controlFont", primaryFontString);
        System.getProperties().put("swing.plaf.metal.menuFont", primaryFontString);
    }
    Font secondaryFont = jEdit.getFontProperty("metal.secondary.font");
    if (secondaryFont != null) {
        String secondaryFontString = fontToString(secondaryFont);
        System.getProperties().put("swing.plaf.metal.systemFont", secondaryFontString);
        System.getProperties().put("swing.plaf.metal.userFont", secondaryFontString);
    }
    // Though the cause is not known, this must precede
    // UIManager.setLookAndFeel(), so that menu bar
    // interaction by ALT key interacts with swing.JMenuBar
    // (which uses L&F) instead of awt.MenuBar which we
    // don't use (and doesn't use L&F).
    // The difference of the behavior was seen on Sun JRE
    // 6u16 on Windows XP and Windows L&F.
    KeyboardFocusManager.setCurrentKeyboardFocusManager(new MyFocusManager());
    // been loaded yet.
    if (EventQueue.isDispatchThread()) {
        try {
            UIManager.setLookAndFeel(sLf);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
    } else {
        try {
            EventQueue.invokeAndWait(new Runnable() {

                public void run() {
                    try {
                        UIManager.setLookAndFeel(sLf);
                    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
                    }
                }
            });
        } catch (InterruptedException | InvocationTargetException e) {
        }
    }
    LookAndFeel lfNew = UIManager.getLookAndFeel();
    if (lfNew != null)
        sLfNew = lfNew.getClass().getName();
    Log.log(Log.DEBUG, jEdit.class, "initPLAF " + (EventQueue.isDispatchThread() ? "edt" : "non-edt") + " old=" + sLfOld + " requested=" + lf + " new=" + sLfNew);
    if (!sLf.equals(sLfNew))
        Log.log(Log.WARNING, jEdit.class, "initPLAF failed to set requested l&f " + lf);
    UIDefaults defaults = UIManager.getDefaults();
    // give all Swing components our colors
    if (jEdit.getBooleanProperty("textColors")) {
        Color background = new javax.swing.plaf.ColorUIResource(jEdit.getColorProperty("view.bgColor"));
        Color foreground = new javax.swing.plaf.ColorUIResource(jEdit.getColorProperty("view.fgColor"));
        Color caretColor = new javax.swing.plaf.ColorUIResource(jEdit.getColorProperty("view.caretColor"));
        Color selectionColor = new javax.swing.plaf.ColorUIResource(jEdit.getColorProperty("view.selectionColor"));
        String[] prefixes = { "PasswordField", "TextField", "TextArea", "List", "Table" };
        for (String prefix : prefixes) {
            defaults.put(prefix + ".foreground", foreground);
            defaults.put(prefix + ".background", background);
            defaults.put(prefix + ".disabledForeground", foreground);
            defaults.put(prefix + ".disabledBackground", background);
            defaults.put(prefix + ".caretForeground", caretColor);
            defaults.put(prefix + ".selectionForeground", foreground);
            defaults.put(prefix + ".selectionBackground", selectionColor);
        }
        defaults.put("ComboBox.foreground", foreground);
        defaults.put("ComboBox.background", background);
        defaults.put("ComboBox.disabledForeground", foreground);
        defaults.put("ComboBox.disabledBackground", background);
        defaults.put("ComboBox.selectedForeground", foreground);
        defaults.put("ComboBox.selectedBackground", selectionColor);
        defaults.put("Tree.background", background);
        defaults.put("Tree.foreground", foreground);
        defaults.put("Tree.textBackground", background);
        defaults.put("Tree.textForeground", foreground);
        defaults.put("Tree.selectionForeground", foreground);
        defaults.put("Tree.selectionBackground", selectionColor);
    }
    defaults.remove("SplitPane.border");
    defaults.remove("SplitPaneDivider.border");
    defaults.put("Tree.rowHeight", 0);
    JFrame.setDefaultLookAndFeelDecorated(getBooleanProperty("decorate.frames"));
    JDialog.setDefaultLookAndFeelDecorated(getBooleanProperty("decorate.dialogs"));
    if (isStartupDone()) {
        int iWindow = 0;
        for (Window window : Window.getWindows()) {
            try {
                SwingUtilities.updateComponentTreeUI(window);
            } catch (Exception e) {
                Log.log(Log.ERROR, jEdit.class, "Window " + iWindow + ": " + window, e);
                break;
            }
            iWindow++;
        }
    }
}