//{{{ isValidName() method
private boolean isValidName(Object name) {
    for (String keymap : keymaps) {
        if (keymap.equals(name))
            return true;
    }
    return false;
//}}}
}