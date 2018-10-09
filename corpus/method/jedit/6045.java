//{{{ getDefaultProperty() method
private String getDefaultProperty(String name) {
    String value = site.getProperty(name);
    if (value != null)
        return value;
    List<Properties> list = Collections.synchronizedList(plugins);
    for (Properties plugin : list) {
        value = plugin.getProperty(name);
        if (value != null)
            return value;
    }
    return system.getProperty(name);
}