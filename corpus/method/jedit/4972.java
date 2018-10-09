//}}}
//{{{ getProperty() method
/**
	 * Returns a mode property.
	 *
	 * @param key The property name
	 * @since jEdit 4.3pre10
	 */
@Override
public Object getProperty(String key) {
    //if(jEdit.getBooleanProperty(prefix + "customSettings"))
    //{
    String prefix = "mode." + name + '.';
    String property = jEdit.getProperty(prefix + key);
    if (property != null) {
        Object value;
        try {
            value = Integer.valueOf(property);
        } catch (NumberFormatException nf) {
            value = property;
        }
        return value;
    }
    //}
    Object value = props.get(key);
    if (value != null)
        return value;
    String global = jEdit.getProperty("buffer." + key);
    if (global != null) {
        try {
            return Integer.valueOf(global);
        } catch (NumberFormatException nf) {
            return global;
        }
    } else
        return null;
}