//{{{ getProperties() method
Properties getProperties() {
    Properties total = new Properties();
    total.putAll(system);
    for (Properties plugin : plugins) total.putAll(plugin);
    total.putAll(site);
    total.putAll(localization);
    for (Properties pluginLocalization : pluginLocalizations) total.putAll(pluginLocalization);
    total.putAll(user);
    return total;
}