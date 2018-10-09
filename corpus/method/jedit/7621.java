private Object parse(String value, Class<?> _class) {
    Object _ret = null;
    if (_class.isArray()) {
        StringTokenizer st = new StringTokenizer(value, String.valueOf(arraysep));
        Class<?> _type = _class.getComponentType();
        _ret = Array.newInstance(_type, st.countTokens());
        int _cnt = st.countTokens();
        for (int i = 0; i < _cnt; i++) {
            Object _val = parse(st.nextToken(), _type);
            if (_val == null)
                return null;
            Array.set(_ret, i, _val);
        }
    } else {
        if (_class == Boolean.class || _class == Boolean.TYPE)
            _ret = Boolean.valueOf(value);
        else if (_class == Character.class || _class == Character.TYPE)
            _ret = Character.valueOf(value.charAt(0));
        else if (_class == Double.class || _class == Double.TYPE)
            _ret = Double.valueOf(value);
        else if (_class == Float.class || _class == Float.TYPE)
            _ret = Float.valueOf(value);
        else if (_class == Integer.class || _class == Integer.TYPE)
            _ret = Integer.valueOf(value);
        else if (_class == Long.class || _class == Long.TYPE)
            _ret = Long.valueOf(value);
        else if (_class == Short.class || _class == Short.TYPE)
            _ret = Short.valueOf(value);
        else if (_class == String.class)
            _ret = value;
        else
            Log.log(Log.WARNING, this, "unsupported type: " + _class.getName());
    }
    return _ret;
}