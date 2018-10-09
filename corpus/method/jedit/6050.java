//}}}
//{{{ getProperty() method
String getProperty(String name) {
    String value = user.getProperty(name);
    if (value != null)
        return value;
    for (Properties pluginLocalization : pluginLocalizations) {
        value = pluginLocalization.getProperty(name);
        if (value != null)
            return value;
    }
    value = localization.getProperty(name);
    if (value != null)
        return value;
    return getDefaultProperty(name);
}