@Override
public boolean isSelected() {
    if (!isVisible())
        return false;
    EditAction a = context.getAction(action);
    if (a == null) {
        Log.log(Log.WARNING, this, "Unknown action: " + action);
        return false;
    }
    try {
        return a.isSelected(EnhancedCheckBoxMenuItem.this);
    } catch (Throwable t) {
        Log.log(Log.ERROR, this, t);
        return false;
    }
}