//}}}
//{{{ unsetProperty() method
/**
	 * Unsets a mode property.
	 * @param key The property name
	 */
@Override
public void unsetProperty(String key) {
    if (initialized) {
        String prefix = "mode." + name + '.';
        jEdit.unsetProperty(prefix + key);
    }
    props.remove(key);
}