public static void set(String name) {
    GUIUtilities.setIconPath("jeditresource:/org/gjt/sp/jedit/icons/themes/" + name + "/");
    jEdit.setProperty("icon-theme", name);
}