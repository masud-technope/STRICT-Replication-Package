@SuppressWarnings({ "unchecked" })
public void setProperties(Map props) {
    if (props == null)
        return;
    ignoreWhitespace = !"false".equalsIgnoreCase((String) props.get("ignoreWhitespace"));
    this.props.putAll(props);
}