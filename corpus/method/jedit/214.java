private void buildDOM() {
    Element plist = this.document.getDocumentElement();
    plist.setAttribute("version", "1.0");
    // Open the top level dictionary, <dict>
    Node dict = createNode("dict", plist);
    // Application short name i.e. About menu name
    writeKeyStringPair("CFBundleName", bundleProperties.getCFBundleName(), dict);
    // Finder 'Version' label, defaults to "1.0"
    writeKeyStringPair("CFBundleShortVersionString", bundleProperties.getCFBundleShortVersionString(), dict);
    // Mac OS X required key, defaults to "false"
    writeKeyStringPair("CFBundleAllowMixedLocalizations", (bundleProperties.getCFBundleAllowMixedLocalizations() ? "true" : "false"), dict);
    // Mac OS X required, defaults to "6.0"
    writeKeyStringPair("CFBundleInfoDictionaryVersion", bundleProperties.getCFBundleInfoDictionaryVersion(), dict);
    // Bundle Executable name, required, defaults to "JavaApplicationStub"
    writeKeyStringPair("CFBundleExecutable", bundleProperties.getCFBundleExecutable(), dict);
    // Bundle Development Region, required, defaults to "English"
    writeKeyStringPair("CFBundleDevelopmentRegion", bundleProperties.getCFBundleDevelopmentRegion(), dict);
    // Bundle Package Type, required, defaults tp "APPL"
    writeKeyStringPair("CFBundlePackageType", bundleProperties.getCFBundlePackageType(), dict);
    // Bundle Signature, required, defaults tp "????"
    writeKeyStringPair("CFBundleSignature", bundleProperties.getCFBundleSignature(), dict);
    // Application build number, optional
    if (bundleProperties.getCFBundleVersion() != null) {
        writeKeyStringPair("CFBundleVersion", bundleProperties.getCFBundleVersion(), dict);
    }
    // Application Icon file, optional
    if (bundleProperties.getCFBundleIconFile() != null) {
        writeKeyStringPair("CFBundleIconFile", bundleProperties.getCFBundleIconFile(), dict);
    }
    // Bundle Identifier, optional
    if (bundleProperties.getCFBundleIdentifier() != null) {
        writeKeyStringPair("CFBundleIdentifier", bundleProperties.getCFBundleIdentifier(), dict);
    }
    // Help Book Folder, optional
    if (bundleProperties.getCFBundleHelpBookFolder() != null) {
        writeKeyStringPair("CFBundleHelpBookFolder", bundleProperties.getCFBundleHelpBookFolder(), dict);
    }
    // Help Book Name, optional
    if (bundleProperties.getCFBundleHelpBookName() != null) {
        writeKeyStringPair("CFBundleHelpBookName", bundleProperties.getCFBundleHelpBookName(), dict);
    }
    // Copyright, optional
    if (bundleProperties.getNSHumanReadableCopyright() != null) {
        writeKeyStringPair("NSHumanReadableCopyright", bundleProperties.getNSHumanReadableCopyright(), dict);
    }
    // HiRes capability, optional
    if (bundleProperties.getNSHighResolutionCapable() != false)
        writeKeyBooleanPair("NSHighResolutionCapable", bundleProperties.getNSHighResolutionCapable(), dict);
    // automatic graphics switching capability, optional
    if (bundleProperties.getNSSupportsAutomaticGraphicsSwitching())
        writeKeyBooleanPair("NSSupportsAutomaticGraphicsSwitching", bundleProperties.getNSSupportsAutomaticGraphicsSwitching(), dict);
    // Content size, optional
    if (bundleProperties.getNSPreferencesContentSize() != null)
        writeKeyStringPair("NSPreferencesContentSize", "{" + bundleProperties.getNSPreferencesContentSize() + "}", dict);
    // IsAgent, optional
    if (bundleProperties.getLSUIElement() != null) {
        writeKeyBooleanPair("LSUIElement", bundleProperties.getLSUIElement(), dict);
    }
    //new since 08/05/2015 by Tobias Bley / UltraMixer
    if (bundleProperties.getLSApplicationCategoryType() != null) {
        writeKeyStringPair("LSApplicationCategoryType", bundleProperties.getLSApplicationCategoryType(), dict);
    }
    //LSEnvironemnt dict node
    if (bundleProperties.getLSEnvironment() != null && bundleProperties.getLSEnvironment().keySet().size() > 0) {
        writeKey("LSEnvironment", dict);
        Node lsEnvironmentDict = createNode("dict", dict);
        // Main class, required
        Enumeration keys = bundleProperties.getLSEnvironment().keys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            writeKeyStringPair(key, (String) bundleProperties.getLSEnvironment().get(key), lsEnvironmentDict);
        }
    }
    // Document Types, optional
    List documentTypes = bundleProperties.getDocumentTypes();
    if (documentTypes.size() > 0) {
        writeDocumentTypes(documentTypes, dict);
    }
    // Java / JavaX entries in the plist dictionary
    if (bundleProperties.getJavaVersion() < 1.7) {
        // Apple Java Version
        writeKey(bundleProperties.getJavaXKey() ? "JavaX" : "Java", dict);
        Node javaDict = createNode("dict", dict);
        // Main class, required
        writeKeyStringPair("MainClass", bundleProperties.getMainClass(), javaDict);
        // Target JVM version, optional but recommended
        if (bundleProperties.getJVMVersion() != null) {
            writeKeyStringPair("JVMVersion", bundleProperties.getJVMVersion(), javaDict);
        }
        // New in JarBundler 2.2.0; Tobias Bley ---------------------------------
        // JVMArchs, optional
        List jvmArchs = bundleProperties.getJVMArchs();
        if (jvmArchs != null && !jvmArchs.isEmpty()) {
            writeJVMArchs(jvmArchs, javaDict);
        }
        // lsArchitecturePriority, optional
        List lsArchitecturePriority = bundleProperties.getLSArchitecturePriority();
        if (lsArchitecturePriority != null && !lsArchitecturePriority.isEmpty()) {
            writeLSArchitecturePriority(lsArchitecturePriority, javaDict);
        }
        //-----------------------------------------------------------------------
        // Classpath is composed of two types, required
        // 1: Jars bundled into the JAVA_ROOT of the application
        // 2: External directories or files with an absolute path
        List classPath = bundleProperties.getClassPath();
        List extraClassPath = bundleProperties.getExtraClassPath();
        if ((classPath.size() > 0) || (extraClassPath.size() > 0)) {
            writeClasspath(classPath, extraClassPath, javaDict);
        }
        // JVM options, optional
        if (bundleProperties.getVMOptions() != null) {
            writeKeyStringPair("VMOptions", bundleProperties.getVMOptions(), javaDict);
        }
        // Working directory, optional
        if (bundleProperties.getWorkingDirectory() != null) {
            writeKeyStringPair("WorkingDirectory", bundleProperties.getWorkingDirectory(), javaDict);
        }
        // StartOnMainThread, optional
        if (bundleProperties.getStartOnMainThread() != null) {
            writeKey("StartOnMainThread", javaDict);
            createNode(bundleProperties.getStartOnMainThread().toString(), javaDict);
        }
        // SplashFile, optional
        if (bundleProperties.getSplashFile() != null) {
            writeKeyStringPair("SplashFile", bundleProperties.getSplashFile(), javaDict);
        }
        // Main class arguments, optional
        if (bundleProperties.getArguments() != null) {
            writeKeyStringPair("Arguments", bundleProperties.getArguments(), javaDict);
        }
        // Java properties, optional
        Hashtable javaProperties = bundleProperties.getJavaProperties();
        if (javaProperties.isEmpty() == false) {
            writeJavaProperties(javaProperties, javaDict);
        }
    } else {
        // Oracle Java Version
        // Main class, required
        writeKeyStringPair("JVMMainClassName", bundleProperties.getMainClass(), dict);
        // Main class arguments, optional
        if (bundleProperties.getArguments() != null) {
            writeKey("JVMArguments", dict);
            writeArray(Arrays.asList(bundleProperties.getArguments().split("\\s+")), dict);
        }
        // JVM options and Java properties, optional
        if ((bundleProperties.getVMOptions() != null) || !bundleProperties.getJavaProperties().isEmpty()) {
            writeKey("JVMOptions", dict);
            List<String> jvmOptions = new ArrayList<String>();
            if (bundleProperties.getVMOptions() != null) {
                jvmOptions.addAll(Arrays.asList(bundleProperties.getVMOptions().split("\\s+")));
            }
            Iterator javaPropertiesIterator = bundleProperties.getJavaProperties().entrySet().iterator();
            while (javaPropertiesIterator.hasNext()) {
                Map.Entry entry = (Map.Entry) javaPropertiesIterator.next();
                if (((String) entry.getKey()).startsWith("com.apple.")) {
                    System.out.println("Deprecated as of 1.4: " + entry.getKey());
                    continue;
                }
                jvmOptions.add("-D" + entry.getKey() + '=' + entry.getValue());
            }
            writeArray(jvmOptions, dict);
        }
    }
    //by Tobias Bley / UltraMixer
    writeKeyStringPair("SUFeedURL", bundleProperties.getSUFeedURL(), dict);
    //Sparkle Properties
    //new since 08/05/2015 by Tobias Bley / UltraMixer
    writeKeyStringPair("SUPublicDSAKeyFile", bundleProperties.getSUPublicDSAKeyFile(), dict);
    // Services, optional
    List services = bundleProperties.getServices();
    if (services.size() > 0) {
        writeServices(services, dict);
    }
}