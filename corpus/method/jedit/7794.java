//}}}
//{{{ getInputStream() method
protected InputStream getInputStream() {
    return Keymap.class.getResourceAsStream(name + "_keys.props");
}