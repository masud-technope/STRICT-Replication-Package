//}}}
//{{{ saveRegisters() method
public static void saveRegisters() {
    if (!loaded || !modified)
        return;
    if (saver != null) {
        saver.saveRegisters();
        modified = false;
    }
}