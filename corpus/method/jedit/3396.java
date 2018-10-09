public static void saveAs(View view) {
    if (jEdit.getSettingsDirectory() == null) {
        GUIUtilities.error(view, "no-settings", null);
        return;
    }
    String layoutName = JOptionPane.showInputDialog(view, jEdit.getProperty(SAVE_LAYOUT_MESSAGE), jEdit.getProperty(SAVE_LAYOUT_TITLE), JOptionPane.QUESTION_MESSAGE);
    if (layoutName == null)
        return;
    if (!save(view, layoutName))
        JOptionPane.showMessageDialog(view, jEdit.getProperty(SAVE_LAYOUT_FAILED));
}