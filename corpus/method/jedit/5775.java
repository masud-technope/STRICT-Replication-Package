boolean canSatisfy() {
    if (isSatisfied())
        return true;
    if (what.equals("plugin"))
        return plugin.canBeInstalled();
    return false;
}