// Public methods
/**
	 * Loads the bean's properties from the given object.
	 */
public void load(Properties p) {
    try {
        PropertyDescriptor[] _props = getPropertyDescriptors();
        for (PropertyDescriptor prop : _props) {
            if ("class".equals(prop.getName()))
                continue;
            Method _set = prop.getWriteMethod();
            if (_set != null) {
                String _pname = root + "." + prop.getName();
                Object _val = p.getProperty(_pname);
                if (_val != null)
                    _val = parse((String) _val, prop.getPropertyType());
                try {
                    _set.invoke(this, _val);
                } catch (IllegalArgumentException iae) {
                }
            }
        }
    } catch (Exception e) {
        Log.log(Log.ERROR, this, e);
    }
}