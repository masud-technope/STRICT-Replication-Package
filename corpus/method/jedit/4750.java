//}}}
//{{{ getMfValue() method
private static String getMfValue(Attributes sectionAttrs, Attributes mainAttrs, Attributes.Name name) {
    String value = null;
    if (sectionAttrs != null)
        value = sectionAttrs.getValue(name);
    else if (mainAttrs != null) {
        value = mainAttrs.getValue(name);
    }
    return value;
}