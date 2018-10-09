//}}}
//{{{ definePackage(packageName, manifest) method
private void definePackage(String name, Manifest mf) {
    if (mf == null) {
        definePackage(name, null, null, null, null, null, null, null);
        return;
    }
    Attributes sa = mf.getAttributes(name.replace('.', '/') + '/');
    Attributes ma = mf.getMainAttributes();
    URL sealBase = null;
    if (Boolean.valueOf(getMfValue(sa, ma, Name.SEALED))) {
        try {
            sealBase = jar.getFile().toURI().toURL();
        }// NOPMD
         catch (MalformedURLException e) {
        }
    }
    definePackage(name, getMfValue(sa, ma, Name.SPECIFICATION_TITLE), getMfValue(sa, ma, Name.SPECIFICATION_VERSION), getMfValue(sa, ma, Name.SPECIFICATION_VENDOR), getMfValue(sa, ma, Name.IMPLEMENTATION_TITLE), getMfValue(sa, ma, Name.IMPLEMENTATION_VERSION), getMfValue(sa, ma, Name.IMPLEMENTATION_VENDOR), sealBase);
}