//{{{ resolveEntity() method
@Override
public InputSource resolveEntity(String publicId, String systemId) {
    return XMLUtilities.findEntity(systemId, "registers.dtd", getClass());
//}}}
}