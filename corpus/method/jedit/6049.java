//}}}
//{{{ setProperty() method
void setProperty(String name, String value) {
    String prop = getDefaultProperty(name);
    /* if value is null:
		 * - if default is null, unset user prop
		 * - else set user prop to ""
		 * else
		 * - if default equals value, ignore
		 * - if default doesn't equal value, set user
		 */
    if (value == null) {
        if (prop == null || prop.length() == 0)
            user.remove(name);
        else
            user.setProperty(name, "");
    } else {
        if (value.equals(prop))
            user.remove(name);
        else
            user.setProperty(name, value);
    }
}