@SuppressWarnings({ "unchecked" })
public  JEditBuffer(Map props) {
    //{{{ need to convert entries of 'props' to PropValue instances
    Set<Map.Entry> set = props.entrySet();
    for (Map.Entry entry : set) {
        properties.put(entry.getKey(), new PropValue(entry.getValue(), false));
    //}}}
    }
    // corresponding buffer.XXX properties not set
    if (getProperty(ENCODING) == null)
        properties.put(ENCODING, new PropValue(System.getProperty("file.encoding"), false));
    if (getProperty(LINESEP) == null)
        properties.put(LINESEP, new PropValue(System.getProperty("line.separator"), false));
    setFoldHandler(new DummyFoldHandler());
}