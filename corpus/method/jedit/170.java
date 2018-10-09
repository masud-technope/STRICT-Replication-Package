public void addConfiguredService(Service service) {
    if (service.getMessage() == null)
        throw new BuildException("\"<service>\" must have a \"message\" attribute");
    String menuItem = service.getMenuItem();
    if (menuItem == null)
        throw new BuildException("\"<service>\" must have a \"menuItem\" attribute");
    if (!menuItems.add(menuItem))
        throw new BuildException("\"<service>\" \"menuItem\" value must be unique");
    if (service.getSendTypes().isEmpty() && service.getReturnTypes().isEmpty())
        throw new BuildException("\"<service>\" must have either a \"sendTypes\" attribute, a \"returnTypes\" attribute or both");
    String keyEquivalent = service.getKeyEquivalent();
    if ((keyEquivalent != null) && (1 != keyEquivalent.length()))
        throw new BuildException("\"<service>\" \"keyEquivalent\" must be one character if present");
    String timeoutString = service.getTimeout();
    if (timeoutString != null) {
        long timeout = -1;
        try {
            timeout = Long.parseLong(timeoutString);
        } catch (NumberFormatException nfe) {
            throw new BuildException("\"<service>\" \"timeout\" must be a positive integral number");
        }
        if (timeout < 0)
            throw new BuildException("\"<service>\" \"timeout\" must not be negative");
    }
    bundleProperties.addService(service);
}