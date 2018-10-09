//}}}
//{{{ main() method
/**
	 * The main method of the jEdit application.
	 * This should never be invoked directly.
	 * @param args The command line arguments
	 */
public static void main(String[] args) {
    StringList slargs = new StringList(args);
    //{{{ Check for Java 1.8 or later
    String javaVersion = System.getProperty("java.version");
    if (javaVersion.compareTo("1.8") < 0) {
        System.err.println("You are running Java version " + javaVersion + '.');
        System.err.println("jEdit requires Java 1.8 or later.");
        System.exit(1);
    //}}}
    }
    startupDone.add(false);
    // later on we need to know if certain code is called from
    // the main thread
    mainThread = Thread.currentThread();
    settingsDirectory = MiscUtilities.constructPath(System.getProperty("user.home"), ".jedit");
    // On mac, different rules (should) apply
    if (OperatingSystem.isMacOS())
        settingsDirectory = MiscUtilities.constructPath(System.getProperty("user.home"), "Library/jEdit");
    else if (OperatingSystem.isWindows()) {
        String appData = System.getenv("APPDATA");
        if (appData != null)
            settingsDirectory = MiscUtilities.constructPath(appData, "jEdit");
    }
    // MacOS users expect the app to keep running after all windows
    // are closed
    background = OperatingSystem.isMacOS();
    // jar manifest file.
    if (OperatingSystem.isX11() && javaVersion.startsWith("1.8")) {
        try {
            Toolkit xToolkit = Toolkit.getDefaultToolkit();
            Field awtAppClassNameField = xToolkit.getClass().getDeclaredField("awtAppClassName");
            awtAppClassNameField.setAccessible(true);
            awtAppClassNameField.set(xToolkit, System.getProperty("x11.wmclass", "jedit"));
        } catch (Exception e) {
            Log.log(Log.ERROR, jEdit.class, e);
        }
    }
    //{{{ Parse command line
    boolean endOpts = false;
    int level = Log.WARNING;
    String portFile = "server";
    boolean restore = true;
    boolean newView = true;
    boolean newPlainView = false;
    // open initial view?
    boolean gui = true;
    boolean loadPlugins = true;
    boolean runStartupScripts = true;
    boolean quit = false;
    boolean wait = false;
    boolean shouldRelocateSettings = true;
    String userDir = System.getProperty("user.dir");
    boolean splash = true;
    // script to run
    String scriptFile = null;
    for (int i = 0; i < args.length; i++) {
        String arg = args[i];
        if (arg == null)
            continue;
        else if (arg.length() == 0)
            args[i] = null;
        else if (arg.startsWith("-") && !endOpts) {
            if (arg.equals("--"))
                endOpts = true;
            else if (arg.equals("-usage")) {
                version();
                System.err.println();
                usage();
                System.exit(1);
            } else if (arg.equals("-version")) {
                version();
                System.exit(1);
            } else if (arg.startsWith("-log=")) {
                try {
                    level = Integer.parseInt(arg.substring("-log=".length()));
                } catch (NumberFormatException nf) {
                    System.err.println("Malformed option: " + arg);
                }
            } else if (arg.equals("-nosettings"))
                settingsDirectory = null;
            else if (arg.startsWith("-settings=")) {
                settingsDirectory = arg.substring(10);
                shouldRelocateSettings = false;
            } else if (arg.startsWith("-noserver"))
                portFile = null;
            else if (arg.equals("-server"))
                portFile = "server";
            else if (arg.startsWith("-server="))
                portFile = arg.substring(8);
            else if (arg.startsWith("-background"))
                background = true;
            else if (arg.startsWith("-nobackground"))
                background = false;
            else if (arg.equals("-gui"))
                gui = true;
            else if (arg.equals("-nogui"))
                gui = false;
            else if (arg.equals("-newview"))
                newView = true;
            else if (arg.equals("-newplainview"))
                newPlainView = true;
            else if (arg.equals("-reuseview"))
                newPlainView = newView = false;
            else if (arg.equals("-restore"))
                restore = true;
            else if (arg.equals("-norestore"))
                restore = false;
            else if (arg.equals("-plugins"))
                loadPlugins = true;
            else if (arg.equals("-noplugins"))
                loadPlugins = false;
            else if (arg.equals("-startupscripts"))
                runStartupScripts = true;
            else if (arg.equals("-nostartupscripts"))
                runStartupScripts = false;
            else if (arg.startsWith("-run="))
                scriptFile = arg.substring(5);
            else if (arg.equals("-wait"))
                wait = true;
            else if (arg.equals("-quit"))
                quit = true;
            else if (arg.equals("-nosplash"))
                splash = false;
            else {
                System.err.println("Unknown option: " + arg);
                usage();
                System.exit(1);
            }
            args[i] = null;
        }
    //}}}
    }
    JTrayIconManager.setTrayIconArgs(restore, userDir, args);
    //{{{ We need these initializations very early on
    if (settingsDirectory != null) {
        settingsDirectory = MiscUtilities.resolveSymlinks(settingsDirectory);
    }
    if (settingsDirectory != null && portFile != null)
        portFile = MiscUtilities.constructPath(settingsDirectory, portFile);
    else
        portFile = null;
    Log.init(true, level);
    Log.log(Log.MESSAGE, jEdit.class, "starting with command line arguments: " + slargs.join(" "));
    //{{{ Try connecting to another running jEdit instance
    if (portFile != null && new File(portFile).exists()) {
        BufferedReader in = null;
        DataOutputStream out = null;
        try {
            in = new BufferedReader(new FileReader(portFile));
            String check = in.readLine();
            if (!"b".equals(check))
                throw new IllegalArgumentException("Wrong port file format");
            int port = Integer.parseInt(in.readLine());
            int key = Integer.parseInt(in.readLine());
            // socket is closed via BeanShell script below
            @SuppressWarnings("resource") Socket socket = new Socket(InetAddress.getByName(null), port);
            out = new DataOutputStream(socket.getOutputStream());
            out.writeInt(key);
            String script;
            if (quit) {
                script = "socket.close();\n" + "jEdit.exit(null,true);\n";
            } else {
                script = makeServerScript(wait, restore, newView, newPlainView, args, scriptFile);
            }
            out.writeUTF(script);
            Log.log(Log.DEBUG, jEdit.class, "Waiting for server");
            // block until its closed
            socket.getInputStream().read();
            System.exit(0);
        } catch (Exception e) {
            Log.log(Log.NOTICE, jEdit.class, "An error occurred" + " while connecting to the jEdit server instance.");
            Log.log(Log.NOTICE, jEdit.class, "This probably means that" + " jEdit crashed and/or exited abnormally");
            Log.log(Log.NOTICE, jEdit.class, "the last time it was run.");
            Log.log(Log.NOTICE, jEdit.class, "If you don't" + " know what this means, don't worry.");
            Log.log(Log.NOTICE, jEdit.class, e);
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }
            if (out != null)
                try {
                    out.close();
                } catch (IOException e) {
                }
        }
    }
    if (quit) {
        // if no server running and user runs jedit -quit,
        // just exit
        System.exit(0);
    //}}}
    }
    // don't show splash screen if there is a file named
    // 'nosplash' in the settings directory
    logTime("before splash screen activation");
    if (splash && (!new File(settingsDirectory, "nosplash").exists()))
        GUIUtilities.showSplashScreen();
    logTime("after splash screen activation");
    // MacOS check introduced in 4.3.
    if ((OperatingSystem.isMacOS() || OperatingSystem.isWindows()) && shouldRelocateSettings && settingsDirectory != null) {
        relocateSettings();
    }
    // }}}
    //{{{ Initialize settings directory
    Writer stream;
    if (settingsDirectory != null) {
        File _settingsDirectory = new File(settingsDirectory);
        if (!_settingsDirectory.exists())
            _settingsDirectory.mkdirs();
        File _macrosDirectory = new File(settingsDirectory, "macros");
        if (!_macrosDirectory.exists())
            _macrosDirectory.mkdir();
        String logPath = MiscUtilities.constructPath(settingsDirectory, "activity.log");
        backupSettingsFile(new File(logPath));
        try {
            stream = new BufferedWriter(new FileWriter(logPath));
            // Write a warning message:
            String lineSep = System.getProperty("line.separator");
            stream.write("Log file created on " + new Date());
            stream.write(lineSep);
            stream.write("IMPORTANT:");
            stream.write(lineSep);
            stream.write("Because updating this file after " + "every log message would kill");
            stream.write(lineSep);
            stream.write("performance, it will be *incomplete* " + "unless you invoke the");
            stream.write(lineSep);
            stream.write("Utilities->Troubleshooting->Update " + "Activity Log on Disk command!");
            stream.write(lineSep);
        } catch (Exception e) {
            e.printStackTrace();
            stream = null;
        }
    } else {
        stream = null;
    //}}}
    }
    Log.setLogWriter(stream);
    Log.log(Log.NOTICE, jEdit.class, "jEdit version " + getVersion());
    Log.log(Log.MESSAGE, jEdit.class, "Settings directory is " + settingsDirectory);
    //{{{ Get things rolling
    GUIUtilities.advanceSplashProgress("init");
    initMisc();
    GUIUtilities.advanceSplashProgress("init system properties");
    initSystemProperties();
    GUIUtilities.advanceSplashProgress("init beanshell");
    BeanShell.init();
    GUIUtilities.advanceSplashProgress("loading site properties");
    if (jEditHome != null)
        initSiteProperties();
    GUIUtilities.advanceSplashProgress("loading user properties");
    initUserProperties();
    initLocalizationProperties();
    GUIUtilities.advanceSplashProgress("init GUI");
    GUIUtilities.init();
    bufferSetManager = new BufferSetManager();
    //{{{ Initialize server
    if (portFile != null) {
        GUIUtilities.advanceSplashProgress("init server");
        server = new EditServer(portFile);
        if (!server.isOK())
            server = null;
    } else {
        GUIUtilities.advanceSplashProgress();
        if (background) {
            background = false;
            Log.log(Log.WARNING, jEdit.class, "You cannot specify both the" + " -background and -noserver switches");
        }
    //}}}
    }
    //{{{ Do more stuff
    GUIUtilities.advanceSplashProgress("init look and feel");
    initPLAF();
    GUIUtilities.advanceSplashProgress("init VFS Manager");
    VFSManager.init();
    GUIUtilities.advanceSplashProgress("init resources");
    initResources();
    if (settingsDirectory != null) {
        GUIUtilities.advanceSplashProgress("Migrate keymaps");
        MigrationService keymapMigration = ServiceManager.getService(MigrationService.class, "keymap");
        keymapMigration.migrate();
    } else
        GUIUtilities.advanceSplashProgress();
    SearchAndReplace.load();
    if (loadPlugins) {
        GUIUtilities.advanceSplashProgress("init plugins");
        initPlugins();
    } else
        GUIUtilities.advanceSplashProgress();
    Registers.setSaver(new JEditRegisterSaver());
    Registers.setListener(new JEditRegistersListener());
    GUIUtilities.advanceSplashProgress("init history model");
    HistoryModel.setSaver(new JEditHistoryModelSaver());
    HistoryModel.loadHistory();
    GUIUtilities.advanceSplashProgress("init buffer history");
    BufferHistory.load();
    GUIUtilities.advanceSplashProgress("init killring");
    KillRing.setInstance(new JEditKillRing());
    KillRing.getInstance().load();
    GUIUtilities.advanceSplashProgress("init various properties");
    // other one-time migration services.
    OneTimeMigrationService.execute();
    propertiesChanged();
    GUIUtilities.advanceSplashProgress("init modes");
    // Buffer sort
    sortBuffers = getBooleanProperty("sortBuffers");
    sortByName = getBooleanProperty("sortByName");
    reloadModes();
    GUIUtilities.advanceSplashProgress("activate plugins");
    //{{{ Activate plugins that must be activated at startup
    for (int i = 0; i < jars.size(); i++) {
        jars.elementAt(i).activatePluginIfNecessary();
    //}}}
    }
    String[] serviceNames = ServiceManager.getServiceNames(JEditTransferableService.class);
    for (String serviceName : serviceNames) {
        JEditTransferableService service = ServiceManager.getService(JEditTransferableService.class, serviceName);
        org.gjt.sp.jedit.datatransfer.TransferHandler.getInstance().registerTransferableService(service);
    }
    //{{{ Load macros and run startup scripts, after plugins and settings are loaded
    GUIUtilities.advanceSplashProgress("init macros");
    Macros.loadMacros();
    Macros.getMacroActionSet().initKeyBindings();
    if (runStartupScripts && jEditHome != null) {
        String path = MiscUtilities.constructPath(jEditHome, "startup");
        File file = new File(path);
        if (file.exists()) {
            GUIUtilities.advanceSplashProgress("run startup scripts");
            runStartupScripts(file);
        } else
            GUIUtilities.advanceSplashProgress();
    } else
        GUIUtilities.advanceSplashProgress();
    if (runStartupScripts && settingsDirectory != null) {
        String path = MiscUtilities.constructPath(settingsDirectory, "startup");
        File file = new File(path);
        if (file.exists()) {
            GUIUtilities.advanceSplashProgress("run startup scripts");
            runStartupScripts(file);
        } else {
            GUIUtilities.advanceSplashProgress();
            file.mkdirs();
        }
    } else {
        GUIUtilities.advanceSplashProgress();
    //}}}
    }
    //{{{ Run script specified with -run= parameter
    if (scriptFile != null) {
        GUIUtilities.advanceSplashProgress("run script file");
        scriptFile = MiscUtilities.constructPath(userDir, scriptFile);
        try {
            BeanShell.getNameSpace().setVariable("args", args);
        } catch (UtilEvalError e) {
            Log.log(Log.ERROR, jEdit.class, e);
        }
        BeanShell.runScript(null, scriptFile, null, false);
    } else {
        GUIUtilities.advanceSplashProgress();
    }
    //}}}
    GUIUtilities.advanceSplashProgress();
    // Create dynamic actions for switching to saved layouts.
    // The list of saved layouts is retrieved from the docking framework,
    // which can be provided by a plugin, so this must be called only after
    // the plugins are loaded.
    DockingLayoutManager.init();
    // Open files, create the view and hide the splash screen.
    SyntaxUtilities.propertyManager = jEdit.propertyManager;
    finishStartup(gui, restore, newPlainView, userDir, args);
    logTime("main done");
}