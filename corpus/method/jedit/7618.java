/**
	 * Cleans the entries related to this object from the given object.
	 */
public void clean(Properties p) {
    try {
        PropertyDescriptor[] _props = getPropertyDescriptors();
        for (PropertyDescriptor prop : _props) {
            if ("class".equals(prop.getName()))
                continue;
            String _pname = root + "." + prop.getName();
            p.remove(_pname);
        }
    } catch (Exception e) {
        Log.log(Log.ERROR, this, e);
    }
}