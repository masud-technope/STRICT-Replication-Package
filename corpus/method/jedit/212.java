private void writeServices(List services, Node appendTo) {
    writeKey("NSServices", appendTo);
    Node array = createNode("array", appendTo);
    Iterator itor = services.iterator();
    while (itor.hasNext()) {
        Service service = (Service) itor.next();
        Node serviceDict = createNode("dict", array);
        String portName = service.getPortName();
        if (portName == null) {
            portName = bundleProperties.getCFBundleName();
        }
        writeKeyStringPair("NSPortName", portName, serviceDict);
        writeKeyStringPair("NSMessage", service.getMessage(), serviceDict);
        List sendTypes = service.getSendTypes();
        if (!sendTypes.isEmpty()) {
            writeKey("NSSendTypes", serviceDict);
            writeArray(sendTypes, serviceDict);
        }
        List returnTypes = service.getReturnTypes();
        if (!returnTypes.isEmpty()) {
            writeKey("NSReturnTypes", serviceDict);
            writeArray(returnTypes, serviceDict);
        }
        writeKey("NSMenuItem", serviceDict);
        Node menuItemDict = createNode("dict", serviceDict);
        writeKeyStringPair("default", service.getMenuItem(), menuItemDict);
        String keyEquivalent = service.getKeyEquivalent();
        if (null != keyEquivalent) {
            writeKey("NSKeyEquivalent", serviceDict);
            Node keyEquivalentDict = createNode("dict", serviceDict);
            writeKeyStringPair("default", keyEquivalent, keyEquivalentDict);
        }
        String userData = service.getUserData();
        if (null != userData) {
            writeKeyStringPair("NSUserData", userData, serviceDict);
        }
        String timeout = service.getTimeout();
        if (null != timeout) {
            writeKeyStringPair("NSTimeout", timeout, serviceDict);
        }
    }
}