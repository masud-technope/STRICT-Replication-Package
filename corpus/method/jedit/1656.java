String getPackage() {
    if (packageName != null)
        return packageName;
    if (parent != null)
        return parent.getPackage();
    return null;
}