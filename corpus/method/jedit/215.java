private Document createDOM() throws ParserConfigurationException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = factory.newDocumentBuilder();
    DOMImplementation domImpl = documentBuilder.getDOMImplementation();
    // We needed to reference using the full class name here because we already have
    //  a class named "DocumentType"
    org.w3c.dom.DocumentType doctype = domImpl.createDocumentType("plist", "-//Apple Computer//DTD PLIST 1.0//EN", "http://www.apple.com/DTDs/PropertyList-1.0.dtd");
    return domImpl.createDocument(null, "plist", doctype);
}