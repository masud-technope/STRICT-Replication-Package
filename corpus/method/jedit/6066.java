//{{{ touchRegister() method
private static void touchRegister(char name) {
    if (name == '%' || name == '$')
        return;
    if (!loaded)
        loadRegisters();
    if (!loading)
        modified = true;
}