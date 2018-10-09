//}}}
//{{{ loadRegisters() method
private static void loadRegisters() {
    if (saver != null) {
        loaded = true;
        saver.loadRegisters();
    }
}