public KeyBinding getBindingAt(int row, int nr) {
    KeyBinding[] binding = bindings.get(row);
    return binding[nr];
}