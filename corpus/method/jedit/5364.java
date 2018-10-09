//}}}
private Mode[] loadSelectedModes() {
    Mode[] modes = jEdit.getModes();
    Arrays.sort(modes, new StandardUtilities.StringCompare<Mode>(true));
    return modes;
}