@Override
public InputSource resolveEntity(String publicId, String systemId) {
    return XMLUtilities.findEntity(systemId, "killring.dtd", getClass());
}