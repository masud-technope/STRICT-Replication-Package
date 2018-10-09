public void addConfiguredDocumentType(DocumentType documentType) throws BuildException {
    String name = documentType.getName();
    String role = documentType.getRole();
    List osTypes = documentType.getOSTypes();
    List extensions = documentType.getExtensions();
    List mimeTypes = documentType.getMimeTypes();
    if ((name == null) || (role == null))
        throw new BuildException("'<documenttype>' must have both a 'name' and a 'role' attibute");
    if ((osTypes.isEmpty()) && (extensions.isEmpty()) && (mimeTypes.isEmpty()))
        throw new BuildException("'<documenttype>' of \"" + name + "\" must have 'osTypes' or 'extensions' or 'mimeTypes'");
    bundleProperties.addDocumentType(documentType);
}