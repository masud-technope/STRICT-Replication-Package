//}}}
//{{{ getDoubleProperty() method
public static double getDoubleProperty(String name, double def) {
    String value = getProperty(name);
    if (value == null)
        return def;
    else {
        try {
            return Double.parseDouble(value.trim());
        } catch (NumberFormatException nf) {
            return def;
        }
    }
}