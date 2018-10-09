//}}}
//{{{ getModes() method
/**
	 * @return an array of installed edit modes that have been selected in the
	 * global options. The modes in this array will be sorted by mode name.
	 */
public static Mode[] getModes() {
    Mode[] modes = ModeProvider.instance.getModes();
    Set<Mode> selected = new HashSet<Mode>();
    for (Mode mode : modes) {
        if (!jEdit.getBooleanProperty("mode.opt-out." + mode.getName(), false)) {
            selected.add(mode);
        }
    }
    modes = selected.toArray(new Mode[selected.size()]);
    Arrays.sort(modes, new StandardUtilities.StringCompare<Mode>(true));
    return modes;
}