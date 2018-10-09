//{{{ macroNameToLabel() method
public static String macroNameToLabel(String macroName) {
    int index = macroName.lastIndexOf('/');
    return macroName.substring(index + 1).replace('_', ' ');
}