/**
	 * Saves the bean's properties into the given object.
	 */
public void save(Properties p) {
    try {
        PropertyDescriptor[] _props = getPropertyDescriptors();
        for (PropertyDescriptor prop : _props) {
            if ("class".equals(prop.getName()))
                continue;
            Method _get = prop.getReadMethod();
            if (_get != null) {
                Object _val = _get.invoke(this);
                String _pname = root + "." + prop.getName();
                if (_val != null)
                    p.setProperty(_pname, encode(_val));
                else
                    p.remove(_pname);
            }
        }
    } catch (Exception e) {
        Log.log(Log.ERROR, this, e);
    }
}