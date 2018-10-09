//{{{ createMacro() method
@Override
public Macro createMacro(String macroName, String path) {
    // Remove '.bsh'
    macroName = macroName.substring(0, macroName.length() - 4);
    return new Macro(this, macroName, Macro.macroNameToLabel(macroName), path);
//}}}
}