//}}}
//{{{ getShortcut() method
@Override
public String getShortcut(String name) {
    String property = props.getProperty(name);
    return property;
}