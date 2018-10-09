private void writeDocumentTypes(List documentTypes, Node appendTo) {
    writeKey("CFBundleDocumentTypes", appendTo);
    Node array = createNode("array", appendTo);
    Iterator itor = documentTypes.iterator();
    while (itor.hasNext()) {
        DocumentType documentType = (DocumentType) itor.next();
        Node documentDict = createNode("dict", array);
        writeKeyStringPair("CFBundleTypeName", documentType.getName(), documentDict);
        writeKeyStringPair("CFBundleTypeRole", documentType.getRole(), documentDict);
        File iconFile = documentType.getIconFile();
        if (iconFile != null) {
            writeKeyStringPair("CFBundleTypeIconFile", iconFile.getName(), documentDict);
        }
        List extensions = documentType.getExtensions();
        if (extensions.isEmpty() == false) {
            writeKey("CFBundleTypeExtensions", documentDict);
            writeArray(extensions, documentDict);
        }
        List osTypes = documentType.getOSTypes();
        if (osTypes.isEmpty() == false) {
            writeKey("CFBundleTypeOSTypes", documentDict);
            writeArray(osTypes, documentDict);
        }
        List mimeTypes = documentType.getMimeTypes();
        if (mimeTypes.isEmpty() == false) {
            writeKey("CFBundleTypeMIMETypes", documentDict);
            writeArray(mimeTypes, documentDict);
        }
        List UTIs = documentType.getUTIs();
        if (UTIs.isEmpty() == false) {
            writeKey("LSItemContentTypes", documentDict);
            writeArray(UTIs, documentDict);
        }
        // Only write this key if true
        if (documentType.isBundle()) {
            writeKeyStringPair("LSTypeIsPackage", "true", documentDict);
        }
    }
}