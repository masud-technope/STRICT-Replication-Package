//}}}
//{{{ loadPluginLocalizationProps() method
Properties loadPluginLocalizationProps(Reader in) throws IOException {
    Properties pluginLocalization = new Properties();
    loadProps(pluginLocalization, in);
    pluginLocalizations.add(pluginLocalization);
    return pluginLocalization;
}