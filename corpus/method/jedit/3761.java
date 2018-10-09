@Override
public boolean passFilter(int row, @Nullable String filter) {
    if (filter == null || filter.isEmpty())
        return true;
    Object item = delegated.getElementAt(row);
    if (item == null)
        return true;
    String text = item.toString().toLowerCase();
    if (!showDebug && text.contains("[debug]"))
        return false;
    if (!showMessage && text.contains("[message]"))
        return false;
    if (!showNotice && text.contains("[notice]"))
        return false;
    if (!showWarning && text.contains("[warning]"))
        return false;
    if (!showError && text.contains("[error]"))
        return false;
    return text.contains(filter);
}