// returns all modes
private Mode[] loadAllModes() {
    Mode[] modes = jEdit.getAllModes();
    Arrays.sort(modes, new StandardUtilities.StringCompare<Mode>(true));
    return modes;
}