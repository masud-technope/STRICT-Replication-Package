//}}}
//{{{ resolveEntity() method
public InputSource resolveEntity(String publicId, String systemId) {
    return XMLUtilities.findEntity(systemId, "plugins.dtd", getClass());
}