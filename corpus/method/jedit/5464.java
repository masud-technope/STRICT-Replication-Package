public String getToolTip(int row) {
    KeyBinding bindingAt = getBindingAt(row, 0);
    return bindingAt.tooltip;
}