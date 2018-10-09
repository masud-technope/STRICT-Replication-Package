//}}}
//{{{ setProperty() method
/**
	 * Sets a mode property.
	 * @param key The property name
	 * @param value The property value
	 */
@Override
public void setProperty(String key, Object value) {
    if (initialized) {
        String prefix = "mode." + name + '.';
        jEdit.setProperty(prefix + key, value.toString());
    }
    props.put(key, value);
}