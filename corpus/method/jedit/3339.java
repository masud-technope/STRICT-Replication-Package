private int match(KeyEvent e, List<Key> shortcut, int index) {
    char c = e.getKeyChar();
    if (shortcut != null && c == shortcut.get(index).key)
        return index + 1;
    return 0;
}