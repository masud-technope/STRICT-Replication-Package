public static void load(View view) {
    if (jEdit.getSettingsDirectory() == null) {
        GUIUtilities.error(view, "no-settings", null);
        return;
    }
    String layoutName = (String) JOptionPane.showInputDialog(view, jEdit.getProperty(LOAD_LAYOUT_MESSAGE), jEdit.getProperty(LOAD_LAYOUT_TITLE), JOptionPane.QUESTION_MESSAGE, null, getSavedLayouts(), null);
    if (layoutName == null)
        return;
    load(view, layoutName);
}