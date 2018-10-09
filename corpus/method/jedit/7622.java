private String encode(Object value) {
    Class<?> _class = value.getClass();
    if (_class.isArray()) {
        StringBuilder _val = new StringBuilder();
        int _len = Array.getLength(value);
        for (int i = 0; i < _len; i++) {
            String _str = encode(Array.get(value, i));
            if (_str == null)
                return null;
            _val.append(_str);
            if (i < _len - 1)
                _val.append(arraysep);
        }
        return _val.toString();
    } else {
        // just make sure it's a supported type.
        if (_class != Boolean.class && _class != Boolean.TYPE && _class != Character.class && _class != Character.TYPE && _class != Double.class && _class != Double.TYPE && _class != Float.class && _class != Float.TYPE && _class != Integer.class && _class != Integer.TYPE && _class != Long.class && _class != Long.TYPE && _class != Short.class && _class != Short.TYPE && _class != String.class) {
            Log.log(Log.WARNING, this, "unsupported type: " + _class.getName());
            return null;
        }
        return value.toString();
    }
}