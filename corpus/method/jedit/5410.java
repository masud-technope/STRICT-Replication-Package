//}}}
private Mode[] reloadModes() {
    Mode[] modes = jEdit.getModes();
    Arrays.sort(modes, new StandardUtilities.StringCompare<Mode>(true));
    global = new ModeProperties();
    modeProps = new ModeProperties[modes.length];
    modeNames = new String[modes.length + 1];
    modeNames[0] = jEdit.getProperty("options.editing.global");
    for (int i = 0; i < modes.length; i++) {
        modeProps[i] = new ModeProperties(modes[i]);
        modeNames[i + 1] = modes[i].getName();
    }
    return modes;
}