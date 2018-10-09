private void writeJavaProperties(Hashtable javaProperties, Node appendTo) {
    writeKey("Properties", appendTo);
    Node propertiesDict = createNode("dict", appendTo);
    for (Iterator i = javaProperties.keySet().iterator(); i.hasNext(); ) {
        String key = (String) i.next();
        if (key.startsWith("com.apple.") && (bundleProperties.getJavaVersion() >= 1.4)) {
            System.out.println("Deprecated as of 1.4: " + key);
            continue;
        }
        writeKeyStringPair(key, (String) javaProperties.get(key), propertiesDict);
    }
}