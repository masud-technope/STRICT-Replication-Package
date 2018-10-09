//}}}
//{{{ getPlatformShortcutLabel() method
/**
	* Translates a shortcut description string (e.g. "CS+SEMICOLON") to
	* a platform-localized description.  On OS X this puts in the pretty
	* unicode characters for Shift, Cmd, etc.
	*/
public static String getPlatformShortcutLabel(String label) {
    if (!OperatingSystem.isMacOSLF() || label == null || label.length() == 0)
        return label;
    String[] strokes = label.split(" +");
    StringBuilder out = new StringBuilder();
    for (int i = 0; i < strokes.length; i++) {
        if (i > 0)
            out.append(' ');
        out.append(getMacShortcutLabel(strokes[i]));
    }
    return out.toString();
}