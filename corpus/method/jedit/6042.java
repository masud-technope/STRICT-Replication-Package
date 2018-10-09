//}}}
//{{{ loadLocalizationProps() method
void loadLocalizationProps(Reader in) throws IOException {
    if (in == null)
        localization.clear();
    else
        loadProps(localization, in);
}