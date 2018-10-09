//}}}
//{{{ getFlag() method
private boolean isAutoreloadPropertyOverriden() {
    return getFlag(AUTORELOAD) != jEdit.getBooleanProperty("autoReload") || getFlag(AUTORELOAD_DIALOG) != jEdit.getBooleanProperty("autoReloadDialog");
}